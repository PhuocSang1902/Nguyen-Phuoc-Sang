import { NextRequest } from 'next/server';
import https from 'https';
import { connectMongo } from '@/lib/mongodb';
import { Customer } from '@/models/customer';
import { Comment } from '@/models/comment';
import { processCommentLocalBatch } from '@/lib/ollama'; // 👈 import batch

const PAGE_ACCESS_TOKEN = process.env.PAGE_ACCESS_TOKEN as string;

const commentBuffer: {
  id: string;
  fbUserId: string;
  fbUserName: string;
  message: string;
  createdTime: string;
}[] = []; // Buffer comment chờ đủ 5 cái

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const liveVideoId = searchParams.get('live_video_id');

  if (!liveVideoId) {
    return new Response('Missing live_video_id parameter', { status: 400 });
  }

  await connectMongo();

  const { readable, writable } = new TransformStream();
  const writer = writable.getWriter();

  const fbRequest = https.request(
    {
      hostname: 'streaming-graph.facebook.com',
      path: `/${liveVideoId}/live_comments?access_token=${PAGE_ACCESS_TOKEN}&fields=from{name,id},message,created_time`,
      method: 'GET',
    },
    (fbRes) => {
      fbRes.on('data', async (chunk) => {
        const data = chunk.toString();
        const sseFormatted = `data: ${data}\n\n`;
        writer.write(new TextEncoder().encode(sseFormatted)); // 👉 gửi thẳng cho client realtime

        try {
          const jsonData = JSON.parse(data);

          const fbUserId = jsonData.sender_id;
          const fbUserName = jsonData.sender_name;
          const message = jsonData.message;
          const createdTime = jsonData.created_time;

          // Push vào buffer
          commentBuffer.push({
            id: jsonData.comment_id,
            fbUserId,
            fbUserName,
            message,
            createdTime,
          });

          // Nếu đủ 5 comment mới batch gửi
          if (commentBuffer.length >= 5) {
            const commentsToProcess = commentBuffer.splice(0, 5); // lấy 5 cái

            const classificationResult = await processCommentLocalBatch(
              commentsToProcess.map((c) => ({ id: c.id, message: c.message }))
            );

            for (const result of classificationResult) {
              const matchingComment = commentsToProcess.find(
                (c) => c.id === result.id
              );

              if (result.type === 'Order' || result.type === 'Interested') {
                let customer = await Customer.findOne({
                  fb_id: matchingComment?.fbUserId,
                });

                if (!customer) {
                  customer = await Customer.create({
                    fb_id: matchingComment?.fbUserId,
                    name: matchingComment?.fbUserName,
                  });
                }

                await Comment.create({
                  message: matchingComment?.message,
                  customer: customer._id,
                  type: result.type,
                  created_time: new Date(matchingComment?.createdTime || ''),
                });
              }
              // Nếu Other thì bỏ qua
            }
          }
        } catch (err) {
          console.error('Error processing comment:', err);
        }
      });

      fbRes.on('end', () => {
        writer.close();
      });
    }
  );

  fbRequest.on('error', (e) => {
    console.error('Error connecting to FB:', e);
    writer.close();
  });

  fbRequest.end();

  const headers = new Headers({
    'Content-Type': 'text/event-stream',
    'Cache-Control': 'no-cache',
    Connection: 'keep-alive',
  });

  return new Response(readable, { headers });
}

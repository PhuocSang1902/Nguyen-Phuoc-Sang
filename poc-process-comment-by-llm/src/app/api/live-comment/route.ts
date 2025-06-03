import { NextRequest } from 'next/server';
import https from 'https';

const PAGE_ACCESS_TOKEN = process.env.PAGE_ACCESS_TOKEN as string;

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const liveVideoId = searchParams.get('live_video_id'); // 👈 lấy từ param URL

  if (!liveVideoId) {
    return new Response('Missing live_video_id parameter', { status: 400 });
  }

  const { readable, writable } = new TransformStream();
  const writer = writable.getWriter();

  const fbRequest = https.request(
    {
      hostname: 'streaming-graph.facebook.com',
      path: `/${liveVideoId}/live_comments?access_token=${PAGE_ACCESS_TOKEN}&fields=from{name},message,created_time`,
      method: 'GET',
    },
    (fbRes) => {
      fbRes.on('data', (chunk) => {
        const data = chunk.toString();
        const sseFormatted = `data: ${data}\n\n`;
        writer.write(new TextEncoder().encode(sseFormatted));
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

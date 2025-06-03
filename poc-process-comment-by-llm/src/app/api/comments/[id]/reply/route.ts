// src/app/api/comments/[id]/reply/route.ts
import { connectMongo } from '@/lib/mongodb';
import { Comment } from '@/models/comment';
import { NextRequest } from 'next/server';
import axios from 'axios';

const PAGE_ACCESS_TOKEN = process.env.PAGE_ACCESS_TOKEN as string;

export async function POST(
  req: NextRequest,
  { params }: { params: { id: string } }
) {
  await connectMongo();

  const { id } = params;
  const { message, method } = await req.json();

  const comment = await Comment.findById(id).populate('customer', 'fb_id');

  if (!comment) {
    return new Response('Comment not found', { status: 404 });
  }

  const fbId = comment.customer.fb_id;

  if (method === 'comment') {
    // Trả lời trực tiếp vào comment
    await axios.post(
      `https://graph.facebook.com/v19.0/${id}/comments`,
      { message },
      { params: { access_token: PAGE_ACCESS_TOKEN } }
    );
  } else if (method === 'private_message') {
    // Nhắn tin riêng (Messenger)
    await axios.post(
      `https://graph.facebook.com/v19.0/me/messages`,
      {
        recipient: { id: fbId },
        message: { text: message },
      },
      { params: { access_token: PAGE_ACCESS_TOKEN } }
    );
  } else {
    return new Response('Invalid method', { status: 400 });
  }

  return new Response('Reply sent', { status: 200 });
}

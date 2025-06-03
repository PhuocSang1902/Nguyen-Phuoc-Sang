// src/app/api/comments/route.ts
import { NextRequest } from 'next/server';
import { connectMongo } from '@/lib/mongodb';
import { Comment } from '@/models/comment';

export async function GET(req: NextRequest) {
  await connectMongo();

  const { searchParams } = new URL(req.url);
  const type = searchParams.get('type');

  if (!type) {
    return new Response('Missing type parameter', { status: 400 });
  }

  const comments = await Comment.find({ type })
    .populate('customer', 'name fb_id')
    .sort({ created_time: -1 })
    .lean();

  return Response.json(comments);
}

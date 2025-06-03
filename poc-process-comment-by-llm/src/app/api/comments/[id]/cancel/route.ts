// src/app/api/comments/[id]/cancel/route.ts
import { connectMongo } from '@/lib/mongodb';
import { Comment } from '@/models/comment';
import { NextRequest } from 'next/server';

export async function POST(
  req: NextRequest,
  { params }: { params: { id: string } }
) {
  await connectMongo();

  const { id } = params;
  await Comment.findByIdAndUpdate(id, { status: 'Cancelled' });

  return new Response('Order cancelled', { status: 200 });
}

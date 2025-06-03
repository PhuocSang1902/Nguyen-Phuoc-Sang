// src/app/api/comments/[id]/process/route.ts
import { connectMongo } from '@/lib/mongodb';
import { Comment } from '@/models/comment';
import { NextRequest } from 'next/server';

export async function POST(
  req: NextRequest,
  { params }: { params: { id: string } }
) {
  await connectMongo();

  const { id } = params;
  await Comment.findByIdAndUpdate(id, { status: 'Processed' });

  return new Response('Order processed', { status: 200 });
}

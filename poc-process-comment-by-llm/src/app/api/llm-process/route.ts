// src/app/api/llm-process/route.ts
import { NextRequest } from 'next/server';
import { processCommentLocal } from '@/lib/ollama';

export async function POST(req: NextRequest) {
  const body = await req.json();
  const { comment } = body;

  if (!comment) {
    return new Response(JSON.stringify({ error: 'Missing comment' }), {
      status: 400,
    });
  }

  try {
    const result = await processCommentLocal(comment);
    return new Response(JSON.stringify({ response: result }), { status: 200 });
  } catch (error) {
    console.error('Error processing comment:', error);
    return new Response(JSON.stringify({ error: 'Internal server error' }), {
      status: 500,
    });
  }
}

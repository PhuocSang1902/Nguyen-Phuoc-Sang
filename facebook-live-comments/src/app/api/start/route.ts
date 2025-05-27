import { NextRequest } from 'next/server';
import { startLiveCommentStream } from '@/lib/liveComments';

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const videoId = searchParams.get('videoId');

  if (!videoId) {
    return new Response(
      JSON.stringify({ error: 'Missing videoId query parameter' }),
      { status: 400 }
    );
  }

  startLiveCommentStream(videoId);
  return new Response(
    `Started listening to live comments for video ID: ${videoId}`
  );
}

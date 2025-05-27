import { EventSource } from 'eventsource';

export function startLiveCommentStream(videoId: string) {
  const accessToken = process.env.PAGE_ACCESS_TOKEN;
  if (!accessToken) {
    console.error('PAGE_ACCESS_TOKEN not set in .env');
    return;
  }

  const url = `https://streaming-graph.facebook.com/${videoId}/live_comments?access_token=${accessToken}&comment_rate=one_per_two_seconds&fields=from{name,id},message`;

  const source = new EventSource(url);

  source.onmessage = (event) => {
    const data = JSON.parse(event.data);
    console.log(`[LIVE COMMENT] ${data.from?.name}: ${data.message}`);
  };

  source.onerror = (err) => {
    console.error('[ERROR] Live comment stream failed:', err);
  };
}

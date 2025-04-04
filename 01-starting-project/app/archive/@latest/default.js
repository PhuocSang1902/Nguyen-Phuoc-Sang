import { getLatestNews } from '@/utils/news';
import NewsList from '@/components/NewsList';

export default function LatestNewsPage() {
  const latestNews = getLatestNews();
  return (
    <>
      <h1>Latest News</h1>
      <NewsList news={latestNews} />
    </>
  );
}

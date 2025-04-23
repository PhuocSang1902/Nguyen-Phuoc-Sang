import { getLatestNews } from '@/utils/news';
import NewsList from '@/components/NewsList';

export default async function LatestNewsPage() {
  const latestNews = await getLatestNews();
  return (
    <>
      <h1>Latest News</h1>
      <NewsList news={latestNews} />
    </>
  );
}

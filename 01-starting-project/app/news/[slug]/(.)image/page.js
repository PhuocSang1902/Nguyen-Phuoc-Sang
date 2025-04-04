import { DUMMY_NEWS } from '@/dummy-news';
import { notFound } from 'next/navigation';

export default function InterceptedImagePage({ params }) {
  const newsItemSlug = params.slug;
  const newsItem = DUMMY_NEWS.find((news) => news.slug === newsItemSlug);

  if (!newsItem) {
    notFound();
  }
  return (
    <>
      <h2>Intercepted Image Page</h2>
      <div className="fullscreen-image">
        <img src={`/images/news/${newsItem.image}`} alt={newsItem.title} />
      </div>
    </>
  );
}

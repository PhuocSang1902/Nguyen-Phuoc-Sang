import React from 'react';
import { getAllNews } from '@/utils/news';
import NewsList from '@/components/NewsList';

export default function NewsPage() {
  const news = getAllNews();
  return (
    <>
      <h1>News Page</h1>
      <NewsList news={news} />
    </>
  );
}

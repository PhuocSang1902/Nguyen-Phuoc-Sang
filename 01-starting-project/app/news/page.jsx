import React from 'react';
import Link from 'next/link';

export default function NewsPage() {
  return (
    <>
      <div>News Page</div>
      <div>
        <Link href="/news/first-news-item">First News Item</Link>
      </div>
      <div>
        <Link href="/news/second-news-item">Second News Item</Link>
      </div>
      <div>
        <Link href="/news/third-news-item">Third News Item</Link>
      </div>
    </>
  );
}

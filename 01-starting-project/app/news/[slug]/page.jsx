import React from 'react';

export default function NewsDetailsPage({ params }) {
  const newsId = params.slug;
  return (
    <div>
      <p>News Details Page</p>
      <p>News id: {newsId}</p>
    </div>
  );
}

// src/app/page.tsx
'use client';

import { useEffect, useState } from 'react';
import axios from 'axios';

interface CommentData {
  comment: string;
  response: string;
}

export default function Home() {
  const [comments, setComments] = useState<CommentData[]>([]);

  useEffect(() => {
    const interval = setInterval(fetchComment, 5000); // 5s fetch 1 comment
    return () => clearInterval(interval);
  }, []);

  async function fetchComment() {
    try {
      const { data } = await axios.get('/api/comments');
      const { comment } = data;
      const response = await axios.post('/api/llm-process', { comment });

      setComments((prev) => [
        ...prev,
        { comment, response: response.data.response },
      ]);
    } catch (error) {
      console.error('Error fetching or processing comment:', error);
    }
  }

  return (
    <main className="min-h-screen p-8 bg-gray-50">
      <h1 className="text-3xl font-bold mb-6">🎯 Live Comment Processor</h1>
      <div className="space-y-4">
        {comments.map((item, index) => (
          <div key={index} className="p-4 border rounded bg-white shadow">
            <p>
              <strong>🗣️ Comment:</strong> {item.comment}
            </p>
            <p>
              <strong>🤖 LLM Response:</strong> {item.response}
            </p>
          </div>
        ))}
      </div>
    </main>
  );
}

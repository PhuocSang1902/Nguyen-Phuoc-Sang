'use client';

import { useEffect, useState, useRef } from 'react';

interface LiveComment {
  comment_id: string;
  sender_id: string;
  sender_name: string;
  message: string;
  created_time: string;
}

const LIVE_VIDEO_ID = '1234567890'; // 👈 id truyền từ ngoài vào nếu cần động hơn có thể làm input

export default function LiveCommentsPage() {
  const [comments, setComments] = useState<LiveComment[]>([]);
  const commentsEndRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    const eventSource = new EventSource(
      `/api/live-comment?live_video_id=${LIVE_VIDEO_ID}`
    );

    eventSource.onmessage = (event) => {
      try {
        const data = JSON.parse(event.data);

        const comment: LiveComment = {
          comment_id: data.comment_id,
          sender_id: data.sender_id,
          sender_name: data.sender_name,
          message: data.message,
          created_time: data.created_time,
        };

        setComments((prev) => [...prev, comment]);
      } catch (err) {
        console.error('Error parsing comment:', err);
      }
    };

    eventSource.onerror = (error) => {
      console.error('EventSource failed:', error);
      eventSource.close();
    };

    return () => {
      eventSource.close();
    };
  }, []);

  useEffect(() => {
    commentsEndRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [comments]);

  return (
    <main className="min-h-screen p-8 bg-gray-50">
      <h1 className="text-3xl font-bold mb-6">🔴 Live Comments</h1>
      <div className="h-[80vh] overflow-y-auto space-y-4 border p-4 bg-white shadow rounded">
        {comments.map((comment) => (
          <div key={comment.comment_id} className="p-4 border-b">
            <p>
              <strong>{comment.sender_name}:</strong> {comment.message}
            </p>
            <p className="text-sm text-gray-500">
              {new Date(comment.created_time).toLocaleString()}
            </p>
          </div>
        ))}
        <div ref={commentsEndRef} />
      </div>
    </main>
  );
}

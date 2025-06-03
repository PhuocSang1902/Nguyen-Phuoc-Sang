'use client';

import { useEffect, useState } from 'react';

interface Customer {
  _id: string;
  name: string;
  fb_id: string;
}

interface Comment {
  _id: string;
  message: string;
  customer: Customer;
  created_time: string;
}

export default function QuestionsPage() {
  const [questions, setQuestions] = useState<Comment[]>([]);
  const [selectedComment, setSelectedComment] = useState<Comment | null>(null);
  const [replyMessage, setReplyMessage] = useState('');
  const [replyMethod, setReplyMethod] = useState<'comment' | 'private_message'>(
    'comment'
  );

  const fetchQuestions = async () => {
    const res = await fetch('/api/comments?type=Interested');
    const data = await res.json();
    setQuestions(data);
  };

  useEffect(() => {
    fetchQuestions();
  }, []);

  const handleSendReply = async () => {
    if (!selectedComment) return;

    await fetch(`/api/comments/${selectedComment._id}/reply`, {
      method: 'POST',
      body: JSON.stringify({
        message: replyMessage,
        method: replyMethod,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    });

    setReplyMessage('');
    setSelectedComment(null);
  };

  return (
    <main className="min-h-screen p-8 bg-gray-50">
      <h1 className="text-3xl font-bold mb-6">💬 Customer Questions</h1>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white rounded shadow">
          <thead>
            <tr>
              <th className="px-4 py-2 border">Customer</th>
              <th className="px-4 py-2 border">Question</th>
              <th className="px-4 py-2 border">Created Time</th>
              <th className="px-4 py-2 border">Actions</th>
            </tr>
          </thead>
          <tbody>
            {questions.map((question) => (
              <tr key={question._id}>
                <td className="border px-4 py-2">{question.customer.name}</td>
                <td className="border px-4 py-2">{question.message}</td>
                <td className="border px-4 py-2">
                  {new Date(question.created_time).toLocaleString()}
                </td>
                <td className="border px-4 py-2">
                  <button
                    onClick={() => setSelectedComment(question)}
                    className="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600"
                  >
                    Trả lời
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Modal trả lời */}
      {selectedComment && (
        <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
          <div className="bg-white p-6 rounded shadow-lg w-96">
            <h2 className="text-xl font-bold mb-4">Phản hồi khách hàng</h2>
            <p className="mb-2 text-gray-700">
              <strong>{selectedComment.customer.name}</strong>:{' '}
              {selectedComment.message}
            </p>
            <textarea
              className="w-full border rounded p-2 mb-4"
              rows={4}
              value={replyMessage}
              onChange={(e) => setReplyMessage(e.target.value)}
              placeholder="Nhập nội dung trả lời..."
            />
            <div className="flex mb-4">
              <label className="mr-4">
                <input
                  type="radio"
                  name="replyMethod"
                  value="comment"
                  checked={replyMethod === 'comment'}
                  onChange={() => setReplyMethod('comment')}
                />
                <span className="ml-2">Trả lời comment</span>
              </label>
              <label>
                <input
                  type="radio"
                  name="replyMethod"
                  value="private_message"
                  checked={replyMethod === 'private_message'}
                  onChange={() => setReplyMethod('private_message')}
                />
                <span className="ml-2">Nhắn tin riêng</span>
              </label>
            </div>
            <div className="flex justify-end space-x-2">
              <button
                onClick={handleSendReply}
                className="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600"
              >
                Gửi
              </button>
              <button
                onClick={() => setSelectedComment(null)}
                className="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600"
              >
                Hủy
              </button>
            </div>
          </div>
        </div>
      )}
    </main>
  );
}

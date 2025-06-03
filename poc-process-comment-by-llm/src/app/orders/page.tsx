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
  status: 'New' | 'Processed' | 'Cancelled';
}

export default function OrdersPage() {
  const [orders, setOrders] = useState<Comment[]>([]);

  const fetchOrders = async () => {
    const res = await fetch('/api/comments?type=Order');
    const data = await res.json();
    setOrders(data);
  };

  useEffect(() => {
    fetchOrders();
  }, []);

  const handleProcess = async (id: string) => {
    await fetch(`/api/comments/${id}/process`, { method: 'POST' });
    fetchOrders(); // refresh
  };

  const handleCancel = async (id: string) => {
    await fetch(`/api/comments/${id}/cancel`, { method: 'POST' });
    fetchOrders();
  };

  return (
    <main className="min-h-screen p-8 bg-gray-50">
      <h1 className="text-3xl font-bold mb-6">🛒 Orders Management</h1>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white rounded shadow">
          <thead>
            <tr>
              <th className="px-4 py-2 border">Customer</th>
              <th className="px-4 py-2 border">Comment</th>
              <th className="px-4 py-2 border">Created Time</th>
              <th className="px-4 py-2 border">Status</th>
              <th className="px-4 py-2 border">Actions</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order._id}>
                <td className="border px-4 py-2">{order.customer.name}</td>
                <td className="border px-4 py-2">{order.message}</td>
                <td className="border px-4 py-2">
                  {new Date(order.created_time).toLocaleString()}
                </td>
                <td className="border px-4 py-2">{order.status}</td>
                <td className="border px-4 py-2 space-x-2">
                  {order.status === 'New' && (
                    <>
                      <button
                        onClick={() => handleProcess(order._id)}
                        className="bg-green-500 text-white px-3 py-1 rounded hover:bg-green-600"
                      >
                        Lên đơn
                      </button>
                      <button
                        onClick={() => handleCancel(order._id)}
                        className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
                      >
                        Hủy
                      </button>
                    </>
                  )}
                  {order.status !== 'New' && (
                    <span className="text-gray-500 italic">Đã xử lý</span>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </main>
  );
}

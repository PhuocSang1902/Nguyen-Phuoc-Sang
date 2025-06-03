import mongoose, { Schema, Document, Types } from 'mongoose';

export interface IComment extends Document {
  message: string;
  customer: Types.ObjectId; // ref Customer
  type: 'Order' | 'Interested';
  created_time: Date;
  status?: 'New' | 'Processed' | 'Cancelled'; // 👈 thêm status cho đơn hàng
}

const CommentSchema: Schema = new Schema({
  message: { type: String, required: true },
  customer: { type: Schema.Types.ObjectId, ref: 'Customer', required: true },
  type: { type: String, enum: ['Order', 'Interested'], required: true },
  created_time: { type: Date, required: true },
  status: {
    type: String,
    enum: ['New', 'Processed', 'Cancelled'],
    default: 'New',
  },
});

export const Comment =
  mongoose.models.Comment || mongoose.model<IComment>('Comment', CommentSchema);

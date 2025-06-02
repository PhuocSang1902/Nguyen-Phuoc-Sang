import mongoose, { Schema, Document } from 'mongoose';

export interface ICustomer extends Document {
  fb_id: string;
  name: string;
}

const CustomerSchema: Schema = new Schema({
  fb_id: { type: String, required: true, unique: true },
  name: { type: String, required: true },
});

export const Customer =
  mongoose.models.Customer ||
  mongoose.model<ICustomer>('Customer', CustomerSchema);

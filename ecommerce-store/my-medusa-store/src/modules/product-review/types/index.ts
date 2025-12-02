export interface Review {
  id: string;
  product_id: string;
  customer_name: string;
  rating: number; // 1-5
  title: string;
  content: string;
  created_at: Date;
  updated_at: Date;
}

export interface CreateReviewInput {
  product_id: string;
  customer_name: string;
  rating: number;
  title: string;
  content: string;
}

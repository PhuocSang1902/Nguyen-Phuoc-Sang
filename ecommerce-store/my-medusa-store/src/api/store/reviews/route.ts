import { MedusaRequest, MedusaResponse } from '@medusajs/framework/http';
import ProductReviewService from '../../../modules/product-review/service';
import { PRODUCT_REVIEW_MODULE } from '../../../modules/product-review';
import { CreateReviewInput } from '../../../modules/product-review/types';

export async function POST(
  req: MedusaRequest<CreateReviewInput>,
  res: MedusaResponse
) {
  const reviewService: ProductReviewService = req.scope.resolve(
    PRODUCT_REVIEW_MODULE
  );

  const { product_id, customer_name, rating, title, content } = req.body;

  // Validation
  if (!product_id || !customer_name || !rating || !title || !content) {
    return res.status(400).json({ error: 'Missing required fields' });
  }

  if (rating < 1 || rating > 5) {
    return res.status(400).json({ error: 'Rating must be between 1 and 5' });
  }

  const review = await reviewService.createReviews({
    product_id,
    customer_name,
    rating,
    title,
    content,
  });

  res.status(201).json({ review });
}

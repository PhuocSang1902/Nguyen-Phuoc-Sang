import { MedusaService } from '@medusajs/framework/utils';
import Review from './models/review';

class ProductReviewService extends MedusaService({
  Review,
}) {
  // Medusa tự động tạo các methods:
  // - createReviews(data)
  // - retrieveReview(id)
  // - listReviews(filters)
  // - updateReviews(id, data)
  // - deleteReviews(id)
}

export default ProductReviewService;

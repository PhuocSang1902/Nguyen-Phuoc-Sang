import { MedusaRequest, MedusaResponse } from '@medusajs/framework/http';
import ProductReviewService from '../../../../modules/product-review/service';
import { PRODUCT_REVIEW_MODULE } from '../../../../modules/product-review';

export async function GET(req: MedusaRequest, res: MedusaResponse) {
  const { productId } = req.params;

  const reviewService: ProductReviewService = req.scope.resolve(
    PRODUCT_REVIEW_MODULE
  );

  const reviews = await reviewService.listReviews({
    product_id: productId,
  });

  res.json({ reviews });
}

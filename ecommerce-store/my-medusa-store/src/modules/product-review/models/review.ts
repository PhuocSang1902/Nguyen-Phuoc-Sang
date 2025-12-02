import { model } from '@medusajs/framework/utils';

const Review = model.define('review', {
  id: model.id().primaryKey(),
  product_id: model.text(),
  customer_name: model.text(),
  rating: model.number(),
  title: model.text(),
  content: model.text(),
});

export default Review;

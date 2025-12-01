import { MedusaRequest, MedusaResponse } from '@medusajs/framework/http';
import { ContainerRegistrationKeys } from '@medusajs/framework/utils';

export async function GET(req: MedusaRequest, res: MedusaResponse) {
  const query = req.scope.resolve(ContainerRegistrationKeys.QUERY);
  const limit = parseInt(query.limit as string) || 10;

  // Query products từ database
  const { data: products } = await query.graph({
    entity: 'product',
    fields: [
      'id',
      'title',
      'handle',
      'thumbnail',
      'variants.*',
      'variants.prices.*',
    ],
    pagination: {
      take: limit,
    },
  });

  return res.json({
    products,
    count: products.length,
  });
}

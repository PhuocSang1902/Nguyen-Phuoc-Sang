import { MedusaRequest, MedusaResponse } from '@medusajs/framework/http';

export async function GET(req: MedusaRequest, res: MedusaResponse) {
  return res.json({
    message: 'Hello from Medusa!',
    timestamp: new Date().toISOString(),
  });
}

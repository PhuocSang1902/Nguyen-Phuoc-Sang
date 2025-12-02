const BACKEND_URL =
  process.env.NEXT_PUBLIC_MEDUSA_BACKEND_URL || "http://localhost:9000"
const PUBLISHABLE_KEY = process.env.NEXT_PUBLIC_MEDUSA_PUBLISHABLE_KEY || ""

export interface Review {
  id: string
  product_id: string
  customer_name: string
  rating: number
  title: string
  content: string
  created_at: string
}

export async function getProductReviews(productId: string): Promise<Review[]> {
  const response = await fetch(`${BACKEND_URL}/store/reviews/${productId}`, {
    headers: {
      "x-publishable-api-key": PUBLISHABLE_KEY,
    },
    next: { revalidate: 60 }, // Cache 60 seconds
  })

  if (!response.ok) {
    return []
  }

  const data = await response.json()
  return data.reviews || []
}

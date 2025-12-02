import { Review } from "@lib/data/reviews"

function StarRating({ rating }: { rating: number }) {
  return (
    <div className="flex gap-1">
      {[1, 2, 3, 4, 5].map((star) => (
        <span
          key={star}
          className={star <= rating ? "text-yellow-400" : "text-gray-300"}
        >
          ★
        </span>
      ))}
    </div>
  )
}

export default function ProductReviews({ reviews }: { reviews: Review[] }) {
  if (reviews.length === 0) {
    return (
      <div className="py-8">
        <h2 className="text-xl font-medium mb-4">Customer Reviews</h2>
        <p className="text-gray-500">No reviews yet. Be the first to review!</p>
      </div>
    )
  }

  const averageRating =
    reviews.reduce((sum, r) => sum + r.rating, 0) / reviews.length

  return (
    <div className="py-8">
      <div className="flex items-center gap-4 mb-6">
        <h2 className="text-xl font-medium">Customer Reviews</h2>
        <div className="flex items-center gap-2">
          <StarRating rating={Math.round(averageRating)} />
          <span className="text-sm text-gray-500">
            ({reviews.length} {reviews.length === 1 ? "review" : "reviews"})
          </span>
        </div>
      </div>

      <div className="space-y-6">
        {reviews.map((review) => (
          <div key={review.id} className="border-b pb-6">
            <div className="flex items-center gap-3 mb-2">
              <StarRating rating={review.rating} />
              <span className="font-medium">{review.customer_name}</span>
              <span className="text-sm text-gray-400">
                {new Date(review.created_at).toLocaleDateString()}
              </span>
            </div>
            <h3 className="font-medium mb-1">{review.title}</h3>
            <p className="text-gray-600">{review.content}</p>
          </div>
        ))}
      </div>
    </div>
  )
}

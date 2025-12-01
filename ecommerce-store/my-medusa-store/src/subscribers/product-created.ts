 import type { SubscriberArgs, SubscriberConfig } from "@medusajs/framework"

  /**
   * Subscriber lắng nghe event "product.created"
   * Chạy mỗi khi có sản phẩm mới được tạo
   */
  export default async function productCreatedHandler({
    event,
    container,
  }: SubscriberArgs<{ id: string }>) {
    // event.data chứa thông tin sản phẩm
    const productId = event.data.id

    console.log("========================================")
    console.log("🎉 NEW PRODUCT CREATED!")
    console.log("Product ID:", productId)
    console.log("Event name:", event.name)
    console.log("Timestamp:", new Date().toISOString())
    console.log("========================================")

    // Có thể mở rộng:
    // - Gửi email thông báo
    // - Sync với hệ thống khác
    // - Gửi webhook
  }

   // Config: đăng ký event cần lắng nghe
  export const config: SubscriberConfig = {
    event: "product.created",
  }
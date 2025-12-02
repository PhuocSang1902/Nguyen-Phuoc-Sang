# Hướng dẫn học MedusaJS - Tài liệu tham khảo

## Mục lục
1. [Giới thiệu MedusaJS](#1-giới-thiệu-medusajs)
2. [Cấu trúc dự án](#2-cấu-trúc-dự-án)
3. [Setup & Khởi động](#3-setup--khởi-động)
4. [Khám phá Medusa Admin](#4-khám-phá-medusa-admin)
5. [Kiến trúc Backend](#5-kiến-trúc-backend)
6. [Storefront Frontend](#6-storefront-frontend)
7. [Các bước học tiếp theo](#7-các-bước-học-tiếp-theo)
8. [Resources](#8-resources)

---

## 1. Giới thiệu MedusaJS

**MedusaJS** là một headless e-commerce platform mã nguồn mở, được xây dựng trên Node.js và TypeScript.

### Đặc điểm chính:
- **Headless Architecture**: Backend (API) tách biệt Frontend
- **Modular**: Dễ dàng thêm/bỏ modules
- **Multi-region, Multi-currency**: Hỗ trợ bán hàng quốc tế
- **Built-in Admin Dashboard**: Quản lý sản phẩm, đơn hàng dễ dàng
- **Workflow-based**: Xử lý business logic phức tạp

### Version trong dự án này:
- **Medusa v2** (2.11.3) - Backend
- **Next.js 15** - Frontend Storefront

---

## 2. Cấu trúc dự án

```
ecommerce-store/
├── docker-compose.yml              # PostgreSQL database
├── my-medusa-store/                # BACKEND (Medusa v2)
│   ├── src/
│   │   ├── api/                    # Custom API endpoints
│   │   │   ├── admin/custom/       # Admin API routes
│   │   │   └── store/custom/       # Store API routes
│   │   ├── workflows/              # Business logic workflows
│   │   ├── subscribers/            # Event listeners
│   │   ├── jobs/                   # Background jobs
│   │   ├── modules/                # Custom modules
│   │   ├── links/                  # Data relationships
│   │   └── scripts/seed.ts         # Seed script
│   ├── medusa-config.ts            # Main config
│   ├── .env.template               # Environment variables
│   └── package.json
│
└── my-medusa-store-storefront/     # FRONTEND (Next.js 15)
    ├── src/
    │   ├── app/                    # Next.js App Router
    │   │   ├── [countryCode]/      # Multi-region routing
    │   │   ├── (main)/             # Main layout group
    │   │   └── (checkout)/         # Checkout layout group
    │   ├── modules/                # Feature modules (13 modules)
    │   │   ├── account/            # User accounts
    │   │   ├── cart/               # Shopping cart
    │   │   ├── checkout/           # Checkout flow
    │   │   ├── products/           # Product catalog
    │   │   ├── categories/         # Product categories
    │   │   └── ...
    │   └── lib/                    # Utilities
    │       ├── data/               # API data handlers
    │       ├── util/               # Helper functions
    │       └── hooks/              # React hooks
    ├── next.config.js
    ├── tailwind.config.js
    └── package.json
```

---

## 3. Setup & Khởi động

### 3.1. Yêu cầu hệ thống
- Node.js >= 20
- Docker (cho PostgreSQL)
- npm hoặc yarn

### 3.2. Khởi động lần đầu

#### Bước 1: PostgreSQL
```bash
cd ecommerce-store
docker-compose up -d
```

Kiểm tra container:
```bash
docker ps  # Xem container 'ecommerce-postgres' đang chạy
```

#### Bước 2: Backend Setup
```bash
cd my-medusa-store

# Copy environment file
cp .env.template .env

# Cài đặt packages
npm install

# Chạy database migrations
npx medusa db:migrate

# Tạo admin user
npx medusa user -e admin@medusa.com -p supersecret

# Seed dữ liệu mẫu
npm run seed

# Khởi động development server
npm run dev
```

Backend sẽ chạy tại: **http://localhost:9000**

#### Bước 3: Frontend Setup
```bash
cd my-medusa-store-storefront

# Cài đặt packages
npm install

# Khởi động development server
npm run dev
```

Storefront sẽ chạy tại: **http://localhost:8000**

### 3.3. Các lần sau
```bash
# Terminal 1: PostgreSQL (nếu chưa chạy)
cd ecommerce-store
docker-compose up -d

# Terminal 2: Backend
cd ecommerce-store/my-medusa-store
npm run dev

# Terminal 3: Frontend
cd ecommerce-store/my-medusa-store-storefront
npm run dev
```

---

## 4. Khám phá Medusa Admin

### 4.1. Truy cập Admin Dashboard

**URL:** http://localhost:9000/app

**Đăng nhập:**
- Email: `admin@medusa.com`
- Password: `supersecret`

### 4.2. Dữ liệu được seed sẵn

#### Products (4 sản phẩm)
1. **Medusa T-Shirt**
   - 8 variants: S/M/L/XL × Black/White
   - Price: €10 EUR / $15 USD
   - Category: Shirts
   - Stock: 1,000,000 mỗi variant

2. **Medusa Sweatshirt**
   - 4 variants: S/M/L/XL
   - Category: Sweatshirts

3. **Medusa Sweatpants**
   - 4 variants: S/M/L/XL
   - Category: Pants

4. **Medusa Shorts**
   - 4 variants: S/M/L/XL
   - Category: Merch

#### Categories
- Shirts
- Sweatshirts
- Pants
- Merch

#### Regions
- **Europe Region**
  - Currency: EUR (default)
  - Countries: GB, DE, DK, SE, FR, ES, IT
  - Payment Provider: System default

#### Store Settings
- Supported Currencies: EUR (default), USD
- Sales Channel: "Default Sales Channel"
- Stock Location: "European Warehouse" (Copenhagen, DK)

#### Shipping Options
- **Standard Shipping**: €10 (2-3 days delivery)
- **Express Shipping**: €10 (24 hours delivery)

### 4.3. Tính năng chính trong Admin

#### Products
- **Quản lý sản phẩm**: Tạo, sửa, xóa
- **Variants**: Quản lý size, color, options
- **Pricing**: Multi-currency pricing
- **Images**: Upload & quản lý hình ảnh
- **Inventory**: Theo dõi stock levels
- **Categories**: Phân loại sản phẩm

#### Orders
- Xem danh sách đơn hàng
- Chi tiết đơn hàng (items, shipping, payment)
- Order status management
- Fulfillment & shipping

#### Customers
- Danh sách khách hàng
- Customer groups
- Order history của từng customer

#### Inventory
- Stock locations management
- Inventory levels theo variant
- Reservations tracking

#### Settings
- **Regions**: Countries, currencies, payment/shipping setup
- **Shipping**: Shipping options, profiles, providers
- **Taxes**: Tax rates & regions
- **Sales Channels**: Multi-channel management
- **API Keys**: Publishable & secret keys
- **Users & Teams**: Admin user management

### 4.4. Thực hành: Tạo sản phẩm mới

**Trong Admin Dashboard:**

1. **Products → New Product**

2. **General Information:**
   - Title: "New Product Name"
   - Subtitle (optional)
   - Description: Chi tiết sản phẩm
   - Handle: URL slug (auto-generated)

3. **Organize:**
   - Category: Chọn category
   - Collections: Thêm vào collections (optional)
   - Tags: Thêm tags để search

4. **Variants:**
   - Add Options: Size, Color, Material...
   - Tạo variants từ options
   - Set prices cho mỗi variant (EUR, USD)
   - SKU codes

5. **Images:**
   - Upload product images
   - Reorder images

6. **Inventory:**
   - Manage inventory: Yes/No
   - Stock quantity cho mỗi variant
   - Stock location

7. **Shipping:**
   - Weight, dimensions
   - Shipping profile

8. **Save & Publish**

---

## 5. Kiến trúc Backend

### 5.1. Medusa v2 Architecture

```
Backend Core:
- Framework: @medusajs/framework
- Database: PostgreSQL
- ORM: TypeORM (abstracted by Medusa)
- Modules: Modular architecture
- Workflows: Business logic orchestration
```

### 5.2. Cấu trúc Backend (my-medusa-store/src/)

#### 5.2.1. API Routes (`src/api/`)

**Admin API** (`src/api/admin/custom/`):
- Custom admin endpoints
- Protected bởi admin authentication
- Example: Custom reports, bulk operations

**Store API** (`src/api/store/custom/`):
- Public API cho storefront
- Customer-facing endpoints
- Example: Custom product filters, recommendations

**Cấu trúc một API route:**
```typescript
// src/api/store/custom/route.ts
import { MedusaRequest, MedusaResponse } from "@medusajs/framework/http"

export async function GET(
  req: MedusaRequest,
  res: MedusaResponse
) {
  // Logic here
  res.json({ data: "response" })
}
```

#### 5.2.2. Workflows (`src/workflows/`)

**Workflows** = Chuỗi các steps để xử lý business logic phức tạp

Ví dụ workflow tạo đơn hàng:
1. Validate cart
2. Calculate totals
3. Process payment
4. Create order
5. Update inventory
6. Send confirmation email

**Built-in workflows** (đã có sẵn):
- `createProductsWorkflow`
- `createOrderWorkflow`
- `createPaymentCollectionWorkflow`
- `createShippingOptionsWorkflow`

**Custom workflow structure:**
```typescript
import { createWorkflow, WorkflowResponse } from "@medusajs/framework/workflows-sdk"

const myCustomWorkflow = createWorkflow(
  "my-custom-workflow",
  (input) => {
    // Define workflow steps
    const result = myStep(input)

    return new WorkflowResponse(result)
  }
)
```

#### 5.2.3. Subscribers (`src/subscribers/`)

**Event listeners** - Lắng nghe events và trigger actions

Common use cases:
- Gửi email khi đơn hàng được tạo
- Update inventory khi thanh toán thành công
- Sync data với external systems

**Example subscriber:**
```typescript
// src/subscribers/order-placed.ts
import { SubscriberArgs } from "@medusajs/framework"

export default async function orderPlacedHandler({
  event: { data },
  container,
}: SubscriberArgs<{ id: string }>) {
  // Send confirmation email
  // Update analytics
  // Notify warehouse
}
```

#### 5.2.4. Jobs (`src/jobs/`)

**Scheduled jobs** - Chạy định kỳ hoặc background tasks

Examples:
- Daily inventory sync
- Weekly sales reports
- Cleanup old cart data

#### 5.2.5. Modules (`src/modules/`)

**Custom modules** - Mở rộng chức năng của Medusa

Có thể tạo custom modules cho:
- Loyalty points system
- Product reviews & ratings
- Wishlist functionality
- Advanced analytics

#### 5.2.6. Links (`src/links/`)

**Data relationships** - Định nghĩa quan hệ giữa các modules

Example: Link products với custom review module

### 5.3. Configuration Files

#### `medusa-config.ts`
```typescript
export default defineConfig({
  projectConfig: {
    databaseUrl: process.env.DATABASE_URL,
    http: {
      storeCors: process.env.STORE_CORS,
      adminCors: process.env.ADMIN_CORS,
      authCors: process.env.AUTH_CORS,
    },
  },
  admin: {
    // Admin dashboard config
  },
  modules: [
    // Module configurations
  ],
})
```

#### `.env` Variables
```bash
# CORS
STORE_CORS=http://localhost:8000
ADMIN_CORS=http://localhost:5173,http://localhost:9000
AUTH_CORS=http://localhost:5173,http://localhost:9000

# Database
DATABASE_URL=postgres://postgres:postgres@localhost:5432/medusa-v2
DB_NAME=medusa-v2

# Security
JWT_SECRET=supersecret
COOKIE_SECRET=supersecret

# Redis (optional, for caching)
REDIS_URL=redis://localhost:6379
```

### 5.4. API Endpoints

**Admin API:** `http://localhost:9000/admin/*`
- Products: `/admin/products`
- Orders: `/admin/orders`
- Customers: `/admin/customers`

**Store API:** `http://localhost:9000/store/*`
- Products: `/store/products`
- Cart: `/store/cart`
- Customers: `/store/customers`

**Testing API với curl:**
```bash
# Get products (Store API)
curl http://localhost:9000/store/products

# Get admin products (requires authentication)
curl -H "Authorization: Bearer <token>" \
  http://localhost:9000/admin/products
```

### 5.5. Database Structure

Medusa v2 sử dụng PostgreSQL với schema:
- `product` - Sản phẩm
- `product_variant` - Variants
- `product_category` - Categories
- `order` - Đơn hàng
- `cart` - Giỏ hàng
- `customer` - Khách hàng
- `region` - Regions
- `shipping_option` - Shipping options
- `payment_collection` - Payments
- ...

**Xem database:**
```bash
# Connect to PostgreSQL
docker exec -it ecommerce-postgres psql -U postgres -d medusa-v2

# List tables
\dt

# Query products
SELECT * FROM product;
```

---

## 6. Storefront Frontend

### 6.1. Tech Stack
- **Framework:** Next.js 15 (App Router)
- **React:** v19 RC
- **Styling:** Tailwind CSS + Medusa UI preset
- **API Client:** @medusajs/js-sdk
- **Payments:** Stripe integration ready

### 6.2. Cấu trúc Storefront

#### 6.2.1. App Router Structure (`src/app/`)

```
app/
├── [countryCode]/              # Multi-region routing (gb, us, fr...)
│   ├── (main)/                 # Main layout group
│   │   ├── page.tsx            # Homepage
│   │   ├── store/              # Store pages
│   │   ├── products/[handle]/  # Product detail pages
│   │   ├── collections/        # Collection pages
│   │   └── account/            # Account dashboard
│   │       ├── page.tsx        # Account overview
│   │       ├── profile/        # Profile management
│   │       ├── addresses/      # Address book
│   │       └── orders/         # Order history
│   └── (checkout)/             # Checkout layout group
│       ├── cart/               # Shopping cart
│       └── checkout/           # Checkout flow
├── layout.tsx                  # Root layout
└── not-found.tsx               # 404 page
```

#### 6.2.2. Feature Modules (`src/modules/`)

**13 modules tổ chức theo tính năng:**

1. **account/** - User authentication & profile
   - Login/Register components
   - Profile management (name, email, password)
   - Address management
   - Order history

2. **cart/** - Shopping cart
   - Cart items display
   - Item selection/removal
   - Empty cart state

3. **checkout/** - Checkout flow
   - Multi-step checkout
   - Shipping information
   - Payment (Stripe)
   - Order confirmation

4. **products/** - Product catalog
   - Product listing
   - Product details
   - Product images
   - Variants selection

5. **categories/** - Product categorization

6. **collections/** - Product collections

7. **store/** - Store pages & components

8. **home/** - Homepage components

9. **order/** - Order tracking & details

10. **layout/** - Navigation, footer, headers

11. **shipping/** - Shipping information

12. **common/** - Reusable UI components (buttons, inputs...)

13. **skeletons/** - Loading states

#### 6.2.3. Data Layer (`src/lib/data/`)

**API integration handlers:**

- `products.ts` - Lấy products, variants, filtering
- `cart.ts` - Cart operations (add, update, remove)
- `customer.ts` - Customer data, authentication
- `orders.ts` - Order history, order details
- `categories.ts` - Categories tree
- `collections.ts` - Collections
- `regions.ts` - Regions, countries, currencies
- `payment.ts` - Payment methods
- `fulfillment.ts` - Shipping options

**Example usage:**
```typescript
// src/lib/data/products.ts
import { sdk } from "@lib/config"

export async function getProductByHandle(handle: string) {
  const { products } = await sdk.store.product.list({
    handle,
  })
  return products[0]
}
```

#### 6.2.4. Utilities (`src/lib/util/`)

Helper functions:
- `money.ts` - Format currencies (€10.00, $15.00)
- `prices.ts` - Calculate product prices
- `transform-product-preview.ts` - Transform API data
- `get-product-price.ts` - Get cheapest/variants prices
- `sort-products.ts` - Sorting logic

#### 6.2.5. Configuration (`src/lib/config.ts`)

```typescript
import Medusa from "@medusajs/js-sdk"

export const sdk = new Medusa({
  baseUrl: process.env.NEXT_PUBLIC_MEDUSA_BACKEND_URL,
  publishableKey: process.env.NEXT_PUBLIC_MEDUSA_PUBLISHABLE_KEY,
})
```

**Environment variables (.env.local):**
```bash
NEXT_PUBLIC_MEDUSA_BACKEND_URL=http://localhost:9000
NEXT_PUBLIC_MEDUSA_PUBLISHABLE_KEY=<your-publishable-key>
NEXT_PUBLIC_DEFAULT_REGION=eu
```

### 6.3. Styling với Tailwind

#### `tailwind.config.js`
```javascript
module.exports = {
  presets: [require("@medusajs/ui-preset")],
  content: [
    "./src/app/**/*.{js,ts,jsx,tsx}",
    "./src/modules/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'grey-0': '#FFFFFF',
        'grey-5': '#F9FAFB',
        // ...custom colors
      },
    },
  },
}
```

### 6.4. Multi-Region Support

**URL structure:**
- `/gb/` - United Kingdom (EUR)
- `/de/` - Germany (EUR)
- `/us/` - United States (USD)

**Region detection:**
- Auto-detect dựa trên IP
- User có thể switch regions
- Prices tự động convert theo region currency

### 6.5. Stripe Integration

**Setup Stripe:**
1. Create Stripe account
2. Add publishable key vào `.env.local`
3. Configure webhook endpoint

**Payment flow:**
- User enters shipping info
- Selects payment method
- Stripe processes payment
- Order confirmed

---

## 7. Các bước học tiếp theo

### 7.1. Beginner Level (Đã hoàn thành ✓)
- [x] Cài đặt và chạy Medusa
- [x] Khám phá Admin Dashboard
- [x] Hiểu cấu trúc dự án
- [x] Xem dữ liệu seed

### 7.2. Intermediate Level

#### Backend:
1. **Tạo Custom API Endpoint**
   - File: `src/api/store/custom/featured-products/route.ts`
   - Trả về list sản phẩm featured
   - Test bằng curl/Postman

2. **Tạo Custom Workflow**
   - Workflow: Apply discount code
   - Steps: Validate code → Calculate discount → Update cart

3. **Tạo Subscriber**
   - Listen: Order placed event
   - Action: Send custom email confirmation

4. **Tạo Custom Module**
   - Module: Product Reviews
   - Features: Add review, rating, list reviews

#### Frontend:
1. **Tùy chỉnh Homepage**
   - Thêm featured products section
   - Thêm hero banner
   - Customize layout

2. **Tạo Custom Product Filter**
   - Filter by price range
   - Filter by multiple categories
   - Sort options (price, name, newest)

3. **Thêm Wishlist Feature**
   - Add to wishlist button
   - Wishlist page
   - Persist in localStorage hoặc database

### 7.3. Advanced Level

1. **Multi-warehouse Inventory**
   - Multiple stock locations
   - Inventory routing logic
   - Stock transfer workflows

2. **Advanced Pricing**
   - Customer-specific pricing
   - Bulk discounts
   - Dynamic pricing rules

3. **Custom Payment Provider**
   - Integrate payment gateway (VNPay, Momo...)
   - Payment webhook handling

4. **Analytics & Reporting**
   - Sales dashboard
   - Product performance metrics
   - Customer insights

5. **Multi-vendor Marketplace**
   - Vendor registration
   - Vendor products management
   - Commission system

### 7.4. Practice Projects

**Project 1: Fashion Store**
- Add size charts
- Color swatches
- Product recommendations
- Customer reviews

**Project 2: Digital Products Store**
- Downloadable products
- License key generation
- No shipping required

**Project 3: Subscription Box**
- Recurring orders
- Subscription management
- Custom box building

---

## 8. Resources

### 8.1. Official Documentation
- **Medusa Docs:** https://docs.medusajs.com
- **API Reference:** https://docs.medusajs.com/api
- **Medusa v2 Guides:** https://docs.medusajs.com/v2
- **Next.js Storefront:** https://docs.medusajs.com/nextjs-starter

### 8.2. Learning Resources
- **Medusa Blog:** https://medusajs.com/blog
- **YouTube Channel:** MedusaJS official channel
- **Discord Community:** https://discord.gg/medusajs
- **GitHub:** https://github.com/medusajs/medusa

### 8.3. Tools
- **Admin Dashboard:** http://localhost:9000/app
- **API Testing:** Postman, Insomnia, curl
- **Database Client:** pgAdmin, TablePlus, DBeaver
- **Code Editor:** VS Code (recommended extensions):
  - ESLint
  - Prettier
  - Tailwind CSS IntelliSense
  - PostgreSQL

### 8.4. Community
- **Discord:** Hỏi đáp, thảo luận
- **GitHub Discussions:** Feature requests, issues
- **Stack Overflow:** Tag `medusajs`

---

## Checklist học tập

### Setup & Basics
- [x] Chạy PostgreSQL, Backend, Frontend thành công
- [x] Đăng nhập Admin Dashboard
- [x] Xem được products, orders trong Admin
- [x] Test storefront (browse products, add to cart)

### Backend Development
- [x] Tạo custom API endpoint đầu tiên
- [x] Hiểu workflow architecture
- [x] Tạo subscriber để handle events
- [ ] Query database trực tiếp

### Frontend Development
- [ ] Hiểu Next.js App Router structure
- [ ] Customize homepage
- [ ] Tạo custom component
- [ ] Fetch data từ Medusa API

### Advanced
- [ ] Deploy production (backend + frontend)
- [ ] Setup Stripe payments
- [ ] Tạo custom module
- [ ] Build complete feature (reviews, wishlist...)

---

## Ghi chú quan trọng

### Credentials
```
Admin Dashboard:
- URL: http://localhost:9000/app
- Email: admin@medusa.com
- Password: supersecret

Database:
- Host: localhost:5432
- Database: medusa-v2
- User: postgres
- Password: postgres
```

### Useful Commands
```bash
# Backend
npm run dev          # Development server
npm run build        # Build production
npm run seed         # Seed database
npx medusa db:migrate  # Run migrations
npx medusa user      # Create admin user

# Frontend
npm run dev          # Development server
npm run build        # Build production
npm run analyze      # Bundle analysis

# Database
docker-compose up -d        # Start PostgreSQL
docker-compose down         # Stop PostgreSQL
docker exec -it ecommerce-postgres psql -U postgres -d medusa-v2
```

### Troubleshooting

**Backend không start:**
- Kiểm tra PostgreSQL đang chạy: `docker ps`
- Kiểm tra `.env` file có đúng DATABASE_URL
- Chạy lại migrations: `npx medusa db:migrate`

**Frontend không kết nối Backend:**
- Kiểm tra NEXT_PUBLIC_MEDUSA_BACKEND_URL trong `.env.local`
- Kiểm tra CORS settings trong `medusa-config.ts`
- Restart cả backend và frontend

**Database errors:**
- Reset database: Drop và recreate
- Chạy lại migrations và seed

---

**Chúc bạn học tốt MedusaJS!**

---

## Progress Log (for AI context)

### 2025-12-01: Backend API Basics Completed

**Completed:**
- Setup: Docker PostgreSQL, Backend (port 9000), Frontend (port 8000)
- Custom API: `/store/hello`, `/store/featured-products`, `/store/greet`
- Subscriber: `product-created.ts` (listen product.created event)
- Workflow: `hello-workflow.ts` with rollback/compensation

**Files created:**
```
my-medusa-store/src/
├── api/store/
│   ├── hello/route.ts
│   ├── featured-products/route.ts
│   └── greet/route.ts
├── subscribers/
│   └── product-created.ts
└── workflows/
    └── hello-workflow.ts
```

**Key learnings:**
- All `/store/*` routes require `x-publishable-api-key` header (including custom routes)
- Test API on Windows: use Git Bash or `curl.exe` (PowerShell `curl` is alias)
- Workflow rollback: use `StepResponse(output, compensationData)` + compensation function
- `ContainerRegistrationKeys.QUERY` = built-in service for database queries

**Next steps (2025-12-02):**
- [x] Frontend customization (Next.js storefront) ✅
- [ ] Create custom module (Product Reviews/Wishlist)
- [ ] Stripe payment integration

---

### 2025-12-02: Frontend Customization Completed

**Completed:**
- Hiểu cấu trúc Homepage (page.tsx, Hero, FeaturedProducts)
- Hiểu luồng Region/Multi-currency (middleware.ts, getRegion)
- Tạo Collection trong Admin Dashboard để test UI
- Tạo component NewArrivals hiển thị 4 sản phẩm mới nhất
- Tích hợp NewArrivals vào Homepage

**Files created/modified:**
```
my-medusa-store-storefront/src/
├── modules/home/components/
│   └── new-arrivals/
│       └── index.tsx         ← TẠO MỚI
└── app/[countryCode]/(main)/
    └── page.tsx              ← CHỈNH SỬA (thêm import + NewArrivals)
```

**Key learnings:**
- **Server Components**: Dùng `async function` để fetch data trên server
- **Medusa Data Layer**: `listProducts({ regionId, queryParams })` để lấy products
- **Region detection**: middleware.ts tự động detect country từ URL/IP/DEFAULT_REGION
- **Next.js Cache**: Hard refresh `Ctrl+Shift+R` khi data thay đổi ở Admin
- **Tailwind responsive**: `grid-cols-2 small:grid-cols-4` cho mobile/desktop

**Tips:**
- Seed data không tạo collections → FeaturedProducts trống
- DEFAULT_REGION=us nhưng không có US region → fallback country đầu tiên trong map
- Tạo collection trong Admin: Products → Collections → Create

---

### 2025-12-02: Custom Module - Product Reviews Completed

**Completed:**
- Tạo Custom Module product-review với đầy đủ: types, model, service, migrations
- Tạo API endpoints: POST /store/reviews, GET /store/reviews/:productId
- Tích hợp hiển thị reviews trên trang chi tiết sản phẩm (storefront)

**Files created (Backend - my-medusa-store/src/):**
```
modules/product-review/
├── index.ts              # Module definition
├── models/review.ts      # Database model
├── service.ts            # Business logic (CRUD)
├── types/index.ts        # TypeScript interfaces
└── migrations/           # Database migrations

api/store/reviews/
├── route.ts              # POST - tạo review
└── [productId]/route.ts  # GET - lấy reviews theo product
```

**Files created (Frontend - my-medusa-store-storefront/src/):**
```
lib/data/reviews.ts                           # Fetch reviews từ API
modules/products/components/product-reviews/  # Component hiển thị reviews
modules/products/templates/index.tsx          # Tích hợp vào product page
```

**Key learnings:**
- **Custom Module structure**: types → model → service → index.ts → register in medusa-config.ts
- **MedusaService**: Tự động generate CRUD methods (createReviews, listReviews, retrieveReview, updateReviews, deleteReviews)
- **Migrations**: `db:generate moduleName` tạo migration + snapshot, `db:migrate` chạy migrations
- **Modular architecture**: Mỗi module có migrations riêng, có thể tái sử dụng/publish npm
- **API routes**: Dùng `req.scope.resolve(MODULE_NAME)` để lấy service

**Test API (Git Bash):**
```bash
# POST - Tạo review
curl -X POST http://localhost:9000/store/reviews \
  -H "Content-Type: application/json" \
  -H "x-publishable-api-key: pk_xxx" \
  -d '{"product_id": "prod_xxx", "customer_name": "Name", "rating": 5, "title": "Great!", "content": "Love it"}'

# GET - Lấy reviews
curl -H "x-publishable-api-key: pk_xxx" http://localhost:9000/store/reviews/prod_xxx
```

---

### Lộ trình Research đầy đủ MedusaJS

**Mục tiêu:** Hiểu sâu MedusaJS

**Đã hoàn thành:**
- [x] Setup & Cấu trúc dự án
- [x] Custom API endpoints
- [x] Subscribers (event listeners)
- [x] Workflows với rollback
- [x] Frontend Customization (NewArrivals)
- [x] Custom Module - Product Reviews (Backend + Frontend hiển thị)

**Còn lại (theo thứ tự):**

| # | Nội dung | Thời gian | Status |
|---|----------|-----------|--------|
| 1 | Form Submit Review | ~30 phút | Tiếp theo |
| 2 | Custom Module - Wishlist | ~1 giờ | Pending |
| 3 | Module Links (Reviews ↔ Product) | ~30 phút | Pending |
| 4 | Stripe Payment Integration | ~1-2 giờ | Pending |
| 5 | Admin UI Extension | ~1-2 giờ | Pending |
| 6 | Deploy (Backend + Frontend) | ~1-2 giờ | Pending |

**Khi bắt đầu buổi học mới, nói với Claude:**
> "Tiếp tục học MedusaJS, đọc file MEDUSA_LEARNING_GUIDE.md để biết progress"

---

## Quick Reference (for AI)

### API Key requirement
```
/store/*  → ALWAYS needs x-publishable-api-key header
/admin/*  → Needs JWT token
```

### Test API (Git Bash)
```bash
# GET
curl -H "x-publishable-api-key: pk_xxx" http://localhost:9000/store/hello

# POST with JSON
curl -X POST -H "Content-Type: application/json" -H "x-publishable-api-key: pk_xxx" -d '{"name": "Test"}' http://localhost:9000/store/greet
```

### Workflow with rollback
```typescript
const myStep = createStep(
  "step-name",
  async (input) => {
    // Main logic
    return new StepResponse(output, compensationData)
  },
  async (compensationData) => {
    // Rollback logic - runs when ANY later step throws Error
  }
)
```

### Subscriber
```typescript
export default async function handler({ event, container }: SubscriberArgs<{ id: string }>) {
  console.log("Event:", event.name, "Data:", event.data)
}
export const config: SubscriberConfig = { event: "product.created" }
```

### Query database
```typescript
const query = req.scope.resolve(ContainerRegistrationKeys.QUERY)
const { data } = await query.graph({
  entity: "product",
  fields: ["id", "title", "variants.*"],
  pagination: { take: 10 }
})
```

---

### Frontend Component Pattern
```typescript
// Server Component - fetch data on server
export default async function MyComponent({
  region,
}: {
  region: HttpTypes.StoreRegion
}) {
  // Fetch data
  const { response: { products } } = await listProducts({
    regionId: region.id,
    queryParams: { limit: 4 },
  })

  // Early return if no data
  if (!products?.length) return null

  // Render UI
  return (
    <div className="content-container">
      {products.map((p) => <ProductPreview key={p.id} product={p} region={region} />)}
    </div>
  )
}
```

---

### Custom Module Pattern
```typescript
// 1. types/index.ts - Define interfaces
export interface Review {
  id: string
  product_id: string
  rating: number
  // ...
}

// 2. models/review.ts - Database model
import { model } from "@medusajs/framework/utils"
const Review = model.define("review", {
  id: model.id().primaryKey(),
  product_id: model.text(),
  rating: model.number(),
})
export default Review

// 3. service.ts - Business logic
import { MedusaService } from "@medusajs/framework/utils"
import Review from "./models/review"
class ProductReviewService extends MedusaService({ Review }) {}
export default ProductReviewService

// 4. index.ts - Module definition
import { Module } from "@medusajs/framework/utils"
import ProductReviewService from "./service"
export const PRODUCT_REVIEW_MODULE = "productReview"
export default Module(PRODUCT_REVIEW_MODULE, { service: ProductReviewService })

// 5. medusa-config.ts - Register module
modules: [{ resolve: "./src/modules/product-review" }]

// 6. Run migrations
// npx medusa db:generate productReview
// npx medusa db:migrate
```

---

_Last updated: 2025-12-02_

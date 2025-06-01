import { Injectable } from '@nestjs/common';

@Injectable()
export class CommentsService {
  process(content: string, timestamp: string) {
    console.log(`[${timestamp}] Comment: ${content}`);

    // Ví dụ lọc đơn hàng
    const matched = content.toLowerCase().includes('chốt');
    if (matched) {
      console.log('🔔 Detected order comment!');
    }

    return { status: 'received', matched };
  }
}

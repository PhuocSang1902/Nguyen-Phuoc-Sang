import { Module } from '@nestjs/common';
import { LiveCommentService } from './live-comment.service';
import { LiveCommentController } from './live-comment.controller';

@Module({
  controllers: [LiveCommentController],
  providers: [LiveCommentService],
  exports: [LiveCommentService]
})
export class LiveCommentModule {}

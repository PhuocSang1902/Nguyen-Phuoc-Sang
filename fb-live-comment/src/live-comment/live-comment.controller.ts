import { Controller, Param, Get, Post } from '@nestjs/common';
import { LiveCommentService } from './live-comment.service';

@Controller('live-comments')
export class LiveCommentController {
  constructor(private readonly liveCommentService: LiveCommentService) {}

  @Get('comments/:videoId')
  async getComments(@Param('videoId') videoId: string) {
    return this.liveCommentService.getComments(videoId);
  }

  @Post('listen/:videoId')
  listenToComments(@Param('videoId') videoId: string) {
    this.liveCommentService.startListening(videoId);
    return { message: `Đã bắt đầu ghi comment từ video ${videoId}` };
  }
}

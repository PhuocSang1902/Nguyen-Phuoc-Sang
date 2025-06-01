import { Controller, Post, Body } from '@nestjs/common';
import { CommentsService } from './comments.service';

@Controller('comments')
export class CommentsController {
  constructor(private readonly commentsService: CommentsService) {}

  @Post()
  handleComment(@Body() body: { content: string; timestamp: string }) {
    return this.commentsService.process(body.content, body.timestamp);
  }
}

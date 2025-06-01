import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LiveCommentModule } from './live-comment/live-comment.module';
import { CommentsModule } from './comments/comments.module';

@Module({
  imports: [LiveCommentModule, CommentsModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}

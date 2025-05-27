import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { LiveCommentModule } from './live-comment/live-comment.module';

@Module({
  imports: [LiveCommentModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}

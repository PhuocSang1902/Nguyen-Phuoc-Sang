import { Injectable, Logger } from '@nestjs/common';
import axios from 'axios';
import * as fs from 'fs';
import * as path from 'path';
import EventSource from 'eventsource';

@Injectable()
export class LiveCommentService {
  private readonly logger = new Logger(LiveCommentService.name);
  private readonly accessToken: string =
    'EAAY87Q8W8moBO4rMehwsIBfPzJA3S9hWxx8CV5z8fU726BpZBwe78ETC59ROv6vHDzkZAbElKIZAprLnYBKmlV4zMRc9Lp8STqvzDoHjKqCOvxopr221uMZB3i8ZBCU5UMtug8uUsXuqDw5nScm6FxZCgt8LAJ8lB1GPwWL3cJDAZBr2XK4l7SvPPIudvlCCKlh9gNZCNR6lZAaRbZCq0enuMOJ9fHRjRUfcZAZBdZCBF09uLQwUZD';
  private outputPath = path.join(__dirname, '../../comments.txt');
  constructor() {}

  async getComments(videoId: string): Promise<any> {
    const url = `https://graph.facebook.com/v22.0/${videoId}/comments`;

    const response = await axios.get(url, {
      params: {
        access_token: this.accessToken,
      },
    });

    return response.data;
  }

  startListening(videoId: string) {
    const url = `https://streaming-graph.facebook.com/${videoId}/live_comments?access_token=${this.accessToken}&comment_rate=one_per_two_seconds&fields=from{name,id},message,created_time`;

    const eventSource = new EventSource(url);

    eventSource.onmessage = (event) => {
      try {
        const data = JSON.parse(event.data);

        const logLine = `[${data.created_time}] ${data.from.name}: ${data.message}\n`;

        fs.appendFile(this.outputPath, logLine, (err) => {
          if (err) {
            this.logger.error('❌ Ghi file thất bại:', err);
          } else {
            this.logger.log('✅ Đã lưu comment:', logLine.trim());
          }
        });
      } catch (error) {
        this.logger.error('❌ Lỗi xử lý comment:', error);
      }
    };

    eventSource.onerror = (err) => {
      this.logger.error('❌ Lỗi kết nối SSE:', err);
      eventSource.close();
    };

    this.logger.log(`📡 Bắt đầu lắng nghe comment cho video ${videoId}`);
  }
}

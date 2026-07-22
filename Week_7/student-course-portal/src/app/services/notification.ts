import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {
  private instanceId: number = Math.floor(Math.random() * 10000);
  private notifications: string[] = ['System notification: Welcome to Student Course Portal'];

  getInstanceId(): number {
    return this.instanceId;
  }

  getNotifications(): string[] {
    return [...this.notifications];
  }

  addNotification(message: string): void {
    this.notifications.push(message);
  }
}

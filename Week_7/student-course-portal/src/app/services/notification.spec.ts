import { TestBed } from '@angular/core/testing';
import { NotificationService } from './notification';

describe('NotificationService', () => {
  let service: NotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NotificationService]
    });
    service = TestBed.inject(NotificationService);
  });

  it('should create service and add notification', () => {
    expect(service).toBeTruthy();
    service.addNotification('Test Note');
    expect(service.getNotifications()).toContain('Test Note');
  });
});

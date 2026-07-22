import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification';

/* 
 * COMPONENT-LEVEL PROVIDERS EXPLANATION:
 * Providing NotificationService directly inside the @Component decorator providers array creates
 * a component-scoped service instance. Unlike root-provided singletons, every time a new instance 
 * of NotificationComponent is created in the DOM, Angular DI instantiates a NEW isolated 
 * NotificationService instance scoped strictly to that component branch.
 */
@Component({
  selector: 'app-notification',
  standalone: false,
  templateUrl: './notification.html',
  styleUrl: './notification.css',
  providers: [NotificationService]
})
export class NotificationComponent {
  instanceId: number;

  constructor(public notificationService: NotificationService) {
    this.instanceId = this.notificationService.getInstanceId();
  }
}

import { Injectable } from '@angular/core';
import { CanDeactivate } from '@angular/router';
import { ReactiveEnrollmentForm } from '../pages/reactive-enrollment-form/reactive-enrollment-form';

@Injectable({
  providedIn: 'root'
})
export class UnsavedChangesGuard implements CanDeactivate<ReactiveEnrollmentForm> {
  canDeactivate(component: ReactiveEnrollmentForm): boolean {
    if (component.enrollForm && component.enrollForm.dirty && !component.submitted) {
      return window.confirm('You have unsaved changes in your enrollment form. Do you really want to leave?');
    }
    return true;
  }
}

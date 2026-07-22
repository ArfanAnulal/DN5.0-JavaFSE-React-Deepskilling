import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-enrollment-form',
  standalone: false,
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css',
})
export class EnrollmentForm {
  // Form model fields bound with [(ngModel)]
  studentName: string = '';
  studentEmail: string = '';
  courseId: number | null = null;
  preferredSemester: string = 'Odd';
  agreeToTerms: boolean = false;

  // Submission state tracking
  submitted: boolean = false;

  // Task 1: Form submission handler receiving NgForm directive instance
  onSubmit(form: NgForm): void {
    console.log('Template-Driven Form submitted!');
    console.log('Form Valid:', form.valid);
    console.log('Form Value:', form.value);

    if (form.valid) {
      this.submitted = true;
    }
  }

  // Task 2: Form reset handler using form.resetForm()
  onReset(form: NgForm): void {
    form.resetForm({
      preferredSemester: 'Odd',
      agreeToTerms: false
    });
    this.submitted = false;
  }
}

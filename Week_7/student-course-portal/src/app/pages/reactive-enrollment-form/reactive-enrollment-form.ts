import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: false,
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css',
})
export class ReactiveEnrollmentForm implements OnInit {
  enrollForm!: FormGroup;
  submitted: boolean = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // Task 1: Building Reactive Form using FormBuilder
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      // Task 2: Async validator simulateEmailCheck passed as 3rd parameter array
      studentEmail: ['', [Validators.required, Validators.email], [this.simulateEmailCheck.bind(this)]],
      // Task 2: Custom sync validator noCourseCode passed in validators array
      courseId: ['', [Validators.required, this.noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      // Task 2: FormArray for dynamic repeating course fields
      additionalCourses: this.fb.array([])
    });
  }

  // Task 2: Typed getter for FormArray controls
  // EXPLANATION: Adding a strongly-typed getter in TS keeps template code clean and avoids
  // needing explicit unsafe type casting (e.g. $any()) inside Angular HTML template expressions.
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  // Task 2: Custom Synchronous Validator
  // Checks if course code starts with disallowed prefix 'XX'
  noCourseCode(control: AbstractControl): ValidationErrors | null {
    const value: string = control.value ? String(control.value) : '';
    if (value.toUpperCase().startsWith('XX')) {
      return { noCourseCode: true };
    }
    return null;
  }

  // Task 2: Custom Asynchronous Validator
  // Simulates asynchronous server check returning emailTaken error if email contains 'test@' after 800ms
  simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
    return new Promise((resolve) => {
      setTimeout(() => {
        if (control.value && control.value.toLowerCase().includes('test@')) {
          resolve({ emailTaken: true });
        } else {
          resolve(null);
        }
      }, 800);
    });
  }

  // Methods to dynamically add/remove controls in FormArray
  addAdditionalCourse(): void {
    this.additionalCourses.push(this.fb.control('', Validators.required));
  }

  removeAdditionalCourse(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    /* 
     * DIFFERENCE BETWEEN enrollForm.value AND enrollForm.getRawValue():
     * - enrollForm.value returns an object containing values of ENABLED controls only.
     *   Disabled form controls are omitted from the object.
     * - enrollForm.getRawValue() returns an object containing values of ALL controls 
     *   regardless of their disabled/enabled state.
     */
    console.log('Reactive Form Value (Enabled Controls):', this.enrollForm.value);
    console.log('Reactive Form Raw Value (All Controls):', this.enrollForm.getRawValue());

    if (this.enrollForm.valid) {
      this.submitted = true;
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Course } from '../../models/course.model';
import { selectEnrolledCourses } from '../../store/enrollment/enrollment.selectors';
import * as EnrollmentActions from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-student-profile',
  standalone: false,
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css',
})
export class StudentProfile implements OnInit {
  student = {
    name: 'Alex Mercer',
    id: 'STU-2026-889',
    email: 'alex.mercer@university.edu',
    department: 'Computer Science & Engineering',
    gpa: 3.8
  };

  // Task 2: Cross-slice selector Observable from NgRx Store
  enrolledCourses$: Observable<Course[]>;

  constructor(private store: Store) {
    this.enrolledCourses$ = this.store.select(selectEnrolledCourses);
  }

  ngOnInit(): void {}

  onUnenroll(courseId: number): void {
    this.store.dispatch(EnrollmentActions.unenrollFromCourse({ courseId: +courseId }));
  }
}

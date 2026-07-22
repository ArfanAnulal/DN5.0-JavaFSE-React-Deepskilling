import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Course } from '../../models/course.model';
import * as EnrollmentActions from '../../store/enrollment/enrollment.actions';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-card',
  standalone: false,
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnInit, OnChanges {
  @Input() course: Course = {
    id: 0,
    name: '',
    code: '',
    credits: 0,
    gradeStatus: 'pending',
    description: 'Comprehensive course covering core concepts, practical labs, and real-world projects.'
  };

  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded: boolean = false;
  isEnrolled$: Observable<boolean> = new Observable<boolean>();

  constructor(
    private store: Store,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Task 2: Subscribe to NgRx selectEnrolledIds selector to derive enrolled state
    this.isEnrolled$ = this.store.select(selectEnrolledIds).pipe(
      map(enrolledIds => enrolledIds.includes(+this.course.id))
    );
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('CourseCard input changed:', {
        previousValue: changes['course'].previousValue,
        currentValue: changes['course'].currentValue,
        firstChange: changes['course'].isFirstChange()
      });
    }
  }

  get cardClasses(): { [key: string]: boolean } {
    return {
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  get cardBorderStyle(): { [key: string]: string } {
    let color = '#94a3b8';
    if (this.course.gradeStatus === 'passed') {
      color = '#22c55e';
    } else if (this.course.gradeStatus === 'failed') {
      color = '#ef4444';
    }
    return { 'border-left': `6px solid ${color}` };
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  navigateToDetail(): void {
    this.router.navigate(['courses', this.course.id]);
  }

  // Task 2: Dispatching NgRx Enrollment Actions
  onEnrollToggle(currentlyEnrolled: boolean): void {
    if (currentlyEnrolled) {
      this.store.dispatch(EnrollmentActions.unenrollFromCourse({ courseId: +this.course.id }));
    } else {
      this.store.dispatch(EnrollmentActions.enrollInCourse({ courseId: +this.course.id }));
    }
    this.enrollRequested.emit(+this.course.id);
  }
}

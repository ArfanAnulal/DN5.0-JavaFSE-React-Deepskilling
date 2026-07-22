import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../../services/course';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-detail',
  standalone: false,
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css',
})
export class CourseDetail implements OnInit {
  courseId: number = 0;
  course: Course | undefined;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private courseService: CourseService,
    private enrollmentService: EnrollmentService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      this.courseId = +idParam;
      this.courseService.getCourseById(this.courseId).subscribe({
        next: (c) => this.course = c,
        error: (err) => console.error(err)
      });
    }
  }

  get isEnrolled(): boolean {
    return this.course ? this.enrollmentService.isEnrolled(this.course.id) : false;
  }

  toggleEnroll(): void {
    if (this.course) {
      if (this.isEnrolled) {
        this.enrollmentService.unenroll(this.course.id);
      } else {
        this.enrollmentService.enroll(this.course.id);
      }
    }
  }

  goBack(): void {
    this.router.navigate(['/courses']);
  }
}

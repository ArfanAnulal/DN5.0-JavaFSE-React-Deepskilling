import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course';
import { Course } from '../models/course.model';

describe('CourseService Unit Tests', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 101, name: 'Angular v20', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 102, name: 'Java Algorithms', code: 'CS102', credits: 3, gradeStatus: 'passed' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should fetch courses list from API endpoint', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should handle 500 server error gracefully after retries', () => {
    service.getCourses().subscribe({
      next: () => fail('Should have failed with 500 error'),
      error: (err) => {
        expect(err.message).toContain('Server returned code 500');
      }
    });

    // 1 initial request + 2 retries = 3 HTTP requests flushed
    for (let i = 0; i < 3; i++) {
      const req = httpMock.expectOne('http://localhost:3000/courses');
      req.flush('Internal Server Error', { status: 500, statusText: 'Server Error' });
    }
  });
});

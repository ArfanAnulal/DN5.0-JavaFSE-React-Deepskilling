import { TestBed } from '@angular/core/testing';
import { EnrollmentService } from './enrollment';
import { CourseService } from './course';
import { of } from 'rxjs';

describe('EnrollmentService', () => {
  let service: EnrollmentService;

  beforeEach(() => {
    const spy = jasmine.createSpyObj('CourseService', ['getCourses']);
    spy.getCourses.and.returnValue(of([]));

    TestBed.configureTestingModule({
      providers: [
        EnrollmentService,
        { provide: CourseService, useValue: spy }
      ]
    });

    service = TestBed.inject(EnrollmentService);
  });

  it('should enroll and unenroll courses', () => {
    expect(service.isEnrolled(102)).toBeFalse();
    service.enroll(102);
    expect(service.isEnrolled(102)).toBeTrue();
    service.unenroll(102);
    expect(service.isEnrolled(102)).toBeFalse();
  });
});

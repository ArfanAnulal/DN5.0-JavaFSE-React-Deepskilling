import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SimpleChange } from '@angular/core';
import { By } from '@angular/platform-browser';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseCard } from './course-card';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

describe('CourseCardComponent', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;
  let store: MockStore;
  const initialState = {
    enrollment: { enrolledCourseIds: [101] }
  };

  const mockCourse = {
    id: 101,
    name: 'Data Structures & Algorithms',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed' as const,
    description: 'Core computer science course.'
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CourseCard, CreditLabelPipe],
      providers: [provideMockStore({ initialState })]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
  });

  // Task 1: Test 1 - Creation assertion
  it('should create CourseCardComponent', () => {
    expect(component).toBeTruthy();
  });

  // Task 1: Test 2 - @Input rendering test
  it('should render course name and code in DOM when @Input course is set', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    const titleElement = fixture.debugElement.query(By.css('.course-name')).nativeElement;
    const codeElement = fixture.debugElement.query(By.css('.course-code')).nativeElement;

    expect(titleElement.textContent).toContain('Data Structures & Algorithms');
    expect(codeElement.textContent).toContain('CS101');
  });

  // Task 1: Test 3 - @Output event emitting test
  it('should emit enrollRequested event with course ID when enroll button is clicked', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    spyOn(component.enrollRequested, 'emit');

    const button = fixture.debugElement.query(By.css('.btn-card-enroll')).nativeElement;
    button.click();

    expect(component.enrollRequested.emit).toHaveBeenCalledWith(101);
  });

  // Task 1: Test 4 - ngOnChanges lifecycle hook test
  it('should log changes when ngOnChanges is called', () => {
    spyOn(console, 'log');

    component.ngOnChanges({
      course: new SimpleChange(null, mockCourse, true)
    });

    expect(console.log).toHaveBeenCalledWith('CourseCard input changed:', jasmine.any(Object));
  });

  // Task 1: Test 5 - Custom pipe formatting in template
  it('should transform credits using CreditLabelPipe in template', () => {
    component.course = mockCourse; // 4 credits
    fixture.detectChanges();

    const creditsElement = fixture.debugElement.query(By.css('.course-credits')).nativeElement;
    expect(creditsElement.textContent).toContain('4 Credits');
  });
});

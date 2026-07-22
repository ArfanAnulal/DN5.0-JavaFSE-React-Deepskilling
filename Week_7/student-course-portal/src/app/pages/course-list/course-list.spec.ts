import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { CourseList } from './course-list';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseSummaryWidget } from '../../components/course-summary-widget/course-summary-widget';
import { Highlight } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

describe('CourseListComponent with MockStore', () => {
  let component: CourseList;
  let fixture: ComponentFixture<CourseList>;
  let store: MockStore;

  const mockCourses: Course[] = [
    { id: 101, name: 'Angular Testing', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 102, name: 'NgRx Store', code: 'CS102', credits: 3, gradeStatus: 'pending' }
  ];

  const initialState = {
    course: {
      courses: mockCourses,
      loading: false,
      error: null
    },
    enrollment: {
      enrolledCourseIds: [101]
    }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CourseList, CourseCard, CourseSummaryWidget, Highlight, CreditLabelPipe],
      imports: [FormsModule, RouterTestingModule, HttpClientTestingModule],
      providers: [provideMockStore({ initialState }), CourseService]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseList);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
  });

  it('should render course cards corresponding to initial NgRx store state', () => {
    fixture.detectChanges();
    const cardElements = fixture.debugElement.queryAll(By.directive(CourseCard));
    expect(cardElements.length).toBe(2);
  });

  it('should display loading spinner when store loading state is true', () => {
    store.setState({
      course: {
        courses: [],
        loading: true,
        error: null
      },
      enrollment: {
        enrolledCourseIds: []
      }
    });

    fixture.detectChanges();

    const spinner = fixture.debugElement.query(By.css('.spinner'));
    expect(spinner).toBeTruthy();
  });
});

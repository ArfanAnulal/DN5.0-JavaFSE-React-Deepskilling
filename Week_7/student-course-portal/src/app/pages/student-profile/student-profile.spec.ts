import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { provideMockStore } from '@ngrx/store/testing';
import { StudentProfile } from './student-profile';
import { NotificationComponent } from '../../components/notification/notification';
import { NotificationService } from '../../services/notification';

describe('StudentProfile', () => {
  let component: StudentProfile;
  let fixture: ComponentFixture<StudentProfile>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudentProfile, NotificationComponent],
      imports: [RouterTestingModule],
      providers: [
        provideMockStore({ initialState: { course: { courses: [] }, enrollment: { enrolledCourseIds: [] } } }),
        NotificationService
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(StudentProfile);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create StudentProfile component', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CourseDetail } from './course-detail';
import { CourseService } from '../../services/course';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

describe('CourseDetail', () => {
  let component: CourseDetail;
  let fixture: ComponentFixture<CourseDetail>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CourseDetail, CreditLabelPipe],
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [CourseService]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseDetail);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create CourseDetail component', () => {
    expect(component).toBeTruthy();
  });
});

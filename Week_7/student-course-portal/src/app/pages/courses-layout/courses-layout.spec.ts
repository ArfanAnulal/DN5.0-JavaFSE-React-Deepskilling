import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CoursesLayout } from './courses-layout';

describe('CoursesLayout', () => {
  let component: CoursesLayout;
  let fixture: ComponentFixture<CoursesLayout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CoursesLayout],
      imports: [RouterTestingModule]
    }).compileComponents();

    fixture = TestBed.createComponent(CoursesLayout);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create CoursesLayout component', () => {
    expect(component).toBeTruthy();
  });
});

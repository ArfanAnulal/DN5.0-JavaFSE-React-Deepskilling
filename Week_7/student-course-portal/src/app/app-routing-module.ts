import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { CoursesLayout } from './pages/courses-layout/courses-layout';
import { CourseList } from './pages/course-list/course-list';
import { CourseDetail } from './pages/course-detail/course-detail';
import { StudentProfile } from './pages/student-profile/student-profile';
import { NotFound } from './pages/not-found/not-found';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', component: Home },

  // Task 1: Nested routes under /courses layout container
  {
    path: 'courses',
    component: CoursesLayout,
    children: [
      { path: '', component: CourseList },
      { path: ':id', component: CourseDetail }
    ]
  },

  // Task 2: AuthGuard protecting /profile route
  {
    path: 'profile',
    component: StudentProfile,
    canActivate: [AuthGuard]
  },

  // Task 2: Lazy-loaded feature module for enrollment
  {
    path: 'enroll',
    loadChildren: () => import('./features/enrollment/enrollment-module').then(m => m.EnrollmentModule)
  },

  // Task 1: Wildcard 404 route (must be last)
  { path: '**', component: NotFound }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

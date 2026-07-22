import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// NgRx Store, Effects & DevTools
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Header } from './components/header/header';
import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { CourseCard } from './components/course-card/course-card';
import { Highlight } from './directives/highlight';
import { CreditLabelPipe } from './pipes/credit-label-pipe';
import { CourseSummaryWidget } from './components/course-summary-widget/course-summary-widget';
import { NotificationComponent } from './components/notification/notification';
import { CourseDetail } from './pages/course-detail/course-detail';
import { NotFound } from './pages/not-found/not-found';
import { CoursesLayout } from './pages/courses-layout/courses-layout';

import { AuthInterceptor } from './interceptors/auth.interceptor';
import { ErrorHandlerInterceptor } from './interceptors/error-handler.interceptor';
import { LoadingInterceptor } from './interceptors/loading.interceptor';

// NgRx Reducers and Effects
import { courseReducer } from './store/course/course.reducer';
import { enrollmentReducer } from './store/enrollment/enrollment.reducer';
import { CourseEffects } from './store/course/course.effects';

@NgModule({
  declarations: [
    App,
    Header,
    Home,
    CourseList,
    StudentProfile,
    CourseCard,
    Highlight,
    CreditLabelPipe,
    CourseSummaryWidget,
    NotificationComponent,
    CourseDetail,
    NotFound,
    CoursesLayout
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    // Task 1: NgRx Root Store Configuration
    StoreModule.forRoot({
      course: courseReducer,
      enrollment: enrollmentReducer
    }),
    // Task 2: NgRx Effects Configuration
    EffectsModule.forRoot([CourseEffects]),
    // Task 1: Redux DevTools Integration
    StoreDevtoolsModule.instrument({ maxAge: 25 })
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorHandlerInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi: true }
  ],
  bootstrap: [App]
})
export class AppModule { }

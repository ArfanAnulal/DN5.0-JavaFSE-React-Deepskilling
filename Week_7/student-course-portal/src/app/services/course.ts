import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { map, catchError, tap, retry, switchMap } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private apiUrl = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) {}

  // Task 1 & 2: GET with RxJS pipeline (map, tap, retry, catchError)
  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      // Task 2: retry strategy attempts failed requests up to 2 times
      retry(2),

      /* 
       * WHY tap IS PREFERRED FOR SIDE EFFECTS OVER map:
       * - tap operator is explicitly designed for side effects (logging, telemetry, state notifications)
       *   without altering or mutating the stream payload.
       * - map operator is meant for pure data transformations. Adding side effects inside map breaks 
       *   functional purity and can introduce subtle bugs when streams are re-evaluated.
       */
      tap(courses => console.log(`[CourseService] Loaded ${courses.length} courses from API`)),

      // Task 2: map operator transforms/filters API response
      map(courses => courses.filter(c => c.credits > 0)),

      // Task 2: catchError handles network/server failures gracefully
      catchError(this.handleError)
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      retry(2),
      catchError(this.handleError)
    );
  }

  // Task 1: POST operation to create new course
  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course).pipe(
      tap(newCourse => console.log('[CourseService] Created course:', newCourse)),
      catchError(this.handleError)
    );
  }

  // Task 1: PUT operation to update existing course
  updateCourse(course: Course): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course).pipe(
      tap(updated => console.log('[CourseService] Updated course:', updated)),
      catchError(this.handleError)
    );
  }

  // Task 1: DELETE operation to remove course
  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      tap(() => console.log(`[CourseService] Deleted course ID: ${id}`)),
      catchError(this.handleError)
    );
  }

  /* 
   * Task 2: switchMap operator demonstration
   * WHY switchMap CANCELS PREVIOUS INNER OBSERVABLES:
   * - switchMap subscribes to a new inner Observable every time the outer source emits.
   * - When a new outer value arrives before the previous inner Observable completes, switchMap 
   *   automatically unsubscribes (cancels) the in-flight request and switches to the latest one.
   * - This prevents race conditions and out-of-order responses (e.g. typeahead search).
   */
  getCourseStudents(courseId$: Observable<number>): Observable<any> {
    return courseId$.pipe(
      switchMap(id => this.http.get<any>(`http://localhost:3000/enrollments?courseId=${id}`))
    );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.error('[CourseService] HTTP Error:', error);
    let userMsg = 'Failed to communicate with course API server.';
    if (error.error instanceof ErrorEvent) {
      userMsg = `Client Error: ${error.error.message}`;
    } else {
      userMsg = `Server returned code ${error.status}: ${error.message}`;
    }
    return throwError(() => new Error(userMsg));
  }
}

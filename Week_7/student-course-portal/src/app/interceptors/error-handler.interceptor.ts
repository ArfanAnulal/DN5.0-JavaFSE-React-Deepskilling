import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class ErrorHandlerInterceptor implements HttpInterceptor {
  constructor(private router: Router) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMsg = 'An unexpected HTTP error occurred.';
        if (error.status === 401) {
          errorMsg = 'Unauthorized access! Redirecting to home...';
          this.router.navigate(['/']);
        } else if (error.status === 500) {
          errorMsg = 'Server Error (500). Please try again later.';
        } else {
          errorMsg = `HTTP Error ${error.status}: ${error.message}`;
        }
        console.error('ErrorHandlerInterceptor captured:', errorMsg);
        return throwError(() => new Error(errorMsg));
      })
    );
  }
}

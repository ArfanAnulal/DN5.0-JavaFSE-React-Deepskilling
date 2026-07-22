import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Task 3: Clone request and add Authorization header
    const authReq = req.clone({
      setHeaders: { Authorization: 'Bearer mocktoken-12345' }
    });
    return next.handle(authReq);
  }
}

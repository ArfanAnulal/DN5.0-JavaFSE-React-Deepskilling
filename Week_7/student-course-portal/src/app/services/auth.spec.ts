import { TestBed } from '@angular/core/testing';
import { AuthService } from './auth';

describe('AuthService', () => {
  let service: AuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthService);
  });

  it('should be created and return isLoggedIn status', () => {
    expect(service).toBeTruthy();
    expect(service.isLoggedIn()).toBeTrue();
  });
});

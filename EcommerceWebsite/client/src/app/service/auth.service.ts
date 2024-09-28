import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { catchError, Observable, retry } from 'rxjs';
import { DOCUMENT } from '@angular/common';
import { environment } from '../../environments/environment';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    @Inject(DOCUMENT) private document: Document,
    private service: BaseService
  ) { }

  login(email: string = '', password: string = '') {
    const userInfo = { email, password };
    return this.http.post<{email: string, accessToken: string}>(`${environment.baseUrl}/auth/login`, userInfo).pipe(
      catchError(this.service.handleError)
    );
  }

  register(email: string = '', password: string = '', username: string = '') {
    const userInfo = { username, email, password };
    return this.http.post(`${environment.baseUrl}/auth/register`, userInfo).pipe(
      catchError(this.service.handleError)
    );
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  isLoggedIn(): boolean {
    const localStorage = this.document.defaultView?.localStorage;
    if (!localStorage) return false;
    const token = localStorage.getItem('token');
    if (token) return true;
    else return false;
  }
}

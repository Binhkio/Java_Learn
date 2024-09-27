import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DOCUMENT } from '@angular/common';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    @Inject(DOCUMENT) private document: Document
  ) { }

  login(email: string = '', password: string = '') {
    const userInfo = { email, password };
    return this.http.post<{email: string, accessToken: string}>(`${environment.baseUrl}/auth/login`, userInfo);
  }

  register(email: string = '', password: string = '', username: string = '') {
    const userInfo = { username, email, password };
    return this.http.post(`${environment.baseUrl}/auth/register`, userInfo);
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

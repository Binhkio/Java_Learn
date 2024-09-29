import { Inject, Injectable } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    @Inject(DOCUMENT) private document: Document,
    private service: BaseService
  ) { }

  login(email: string = '', password: string = '') {
    const userInfo = { email, password };
    return this.service.post<{email: string, accessToken: string}>('auth/login', userInfo);
  }

  register(email: string = '', password: string = '', username: string = '') {
    const userInfo = { username, email, password };
    return this.service.post('auth/register', userInfo);
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

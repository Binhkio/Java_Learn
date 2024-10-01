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
    return this.service.post<{accessToken: string, tokenType: string}>('auth/login', userInfo);
  }

  register(email: string = '', password: string = '', username: string = '') {
    const userInfo = { username, email, password };
    return this.service.post('auth/register', userInfo);
  }

  logout(): void {
    sessionStorage.removeItem('access_token');
  }

  isLoggedIn(): boolean {
    const sessionStorage = this.document.defaultView?.sessionStorage;
    if (!sessionStorage) return false;
    const token = sessionStorage.getItem('access_token');
    if (token) return true;
    else return false;
  }
}

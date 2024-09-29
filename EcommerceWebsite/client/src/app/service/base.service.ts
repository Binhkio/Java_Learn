import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
  constructor(private http: HttpClient) {}

  get<T>(path: string): Observable<T> {
    return this.http.get<T>(`${environment.baseUrl}/${path}`, {
      headers: this.generateAuthHeaders()
    }).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  post<T>(path: string, body?: Object): Observable<T> {
    return this.http.post<T>(`${environment.baseUrl}/${path}`, body, {
      headers: this.generateAuthHeaders()
    }).pipe(
      catchError(this.handleError)
    );
  }

  put<T>(path: string, body?: Object): Observable<T> {
    return this.http.put<T>(`${environment.baseUrl}/${path}`, body, {
      headers: this.generateAuthHeaders()
    }).pipe(
      catchError(this.handleError)
    );
  }

  delete<T>(path: string): Observable<T> {
    return this.http.delete<T>(`${environment.baseUrl}/${path}`, {
      headers: this.generateAuthHeaders()
    }).pipe(
      catchError(this.handleError)
    );
  }

  generateAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return headers;
  }

  handleError<T>(err: Error, results: Observable<T>) {
    console.error(err, results);
    return throwError(() => err);
  }
}

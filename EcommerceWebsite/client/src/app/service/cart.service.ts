import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { environment } from '../../environments/environment';
import { catchError, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  constructor(private http: HttpClient, private service: BaseService) {}

  getCart() {
    this.http.get(`${environment.baseUrl}/cart`, {
      headers: this.service.generateAuthHeaders()
    }).pipe(
      retry(2),
      catchError(this.service.handleError)
    );
  }
}

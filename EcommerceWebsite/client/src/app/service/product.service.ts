import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { environment } from '../../environments/environment';
import { catchError, Observable, retry } from 'rxjs';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient, private service: BaseService) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.baseUrl}/product/all`, {
      headers: this.service.generateAuthHeaders()
    }).pipe(
      retry(2),
      catchError(this.service.handleError)
    );
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(`${environment.baseUrl}/product/${id}`, {
      headers: this.service.generateAuthHeaders()
    }).pipe(
      retry(2),
      catchError(this.service.handleError)
    );
  }
}

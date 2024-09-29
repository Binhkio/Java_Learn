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
  constructor(private service: BaseService) { }

  getAllProducts(): Observable<Product[]> {
    return this.service.get<Product[]>('product/all');
  }

  getProduct(id: number): Observable<Product> {
    return this.service.get<Product>(`product/${id}`);
  }
}

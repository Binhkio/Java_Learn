import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Catergory } from '../models/category.model';
import { BaseService } from './base.service';
import { catchError, Observable, retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  constructor(private http: HttpClient, private service: BaseService) {}

  getAllCategories(): Observable<Catergory[]> {
    return this.http.get<Catergory[]>(`${environment.baseUrl}/category/all`, {
      headers: this.service.generateAuthHeaders()
    }).pipe(
      retry(2),
      catchError(this.service.handleError)
    );
  }
}

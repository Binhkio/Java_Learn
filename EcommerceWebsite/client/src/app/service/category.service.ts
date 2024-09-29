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
  constructor(private service: BaseService) {}

  getAllCategories() {
    return this.service.get<Catergory[]>('category/all');
  }
}

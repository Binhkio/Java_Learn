import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { Cart } from '../models/cart.model';
import { Item } from '../models/item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  constructor(private service: BaseService) {}

  getCart() {
    return this.service.get<Cart>('cart');
  }

  addToCart(productId: number, quantity: number) {
    return this.service.post<Item>(`item/add?pId=${productId}&quantity=${quantity}`);
  }
}

import { Component } from '@angular/core';
import { Product } from '../../models/product.model';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  product: Product | undefined;
  quantity: number = 1;

  constructor(private productService: ProductService, private route: ActivatedRoute) {}

  ngOnInit() {
    const productId = Number(this.route.snapshot.paramMap.get('id'));
    this.getProductDetail(productId);
  }

  getProductDetail(id: number) {
    this.productService.getProduct(id).subscribe(data => {
      this.product = data;
    })
  }

  addToCart() {
    
  }
}

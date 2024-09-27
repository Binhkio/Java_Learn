import { Component } from '@angular/core';
import { Product } from '../../models/Product';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  products: Product[] | undefined;

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    }, (error) => {
      console.error(error);
    });
  }
}

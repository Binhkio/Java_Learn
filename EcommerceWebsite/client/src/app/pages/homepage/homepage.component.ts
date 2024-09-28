import { Component } from '@angular/core';
import { Product } from '../../models/product.model';
import { ProductService } from '../../service/product.service';
import { Catergory } from '../../models/category.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  products: Product[] = [];
  filteredProducts: Product[] = [];

  constructor(private productService: ProductService, private router: Router) {}

  ngOnInit() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
      this.filteredProducts = this.products;
    });
  }

  selectCategory(checkedCategories: Set<number>) {
    if (checkedCategories.size > 0) {
      this.filteredProducts = this.products.filter(prod => checkedCategories.has(prod.category.id));
    } else {
      this.filteredProducts = this.products;
    }
  }

  viewProductDetail(product: Product) {
    this.router.navigateByUrl(`/product/${product.id}`);
  }
}

import { Component, EventEmitter, Output } from '@angular/core';
import { Catergory } from '../../../models/category.model';
import { CategoryService } from '../../../service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  categories: Catergory[] = [];
  checkedCategories: Set<number> = new Set<number>();
  @Output() categorySelected = new EventEmitter<Set<number>>();

  constructor(private categoryService: CategoryService) {}

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(data => {
      this.categories = data;
    });
  }

  selectCategory(category: Catergory) {
    if (this.checkedCategories.has(category.id)) {
      this.checkedCategories.delete(category.id);
    } else {
      this.checkedCategories.add(category.id);
    }
    this.categorySelected.emit(this.checkedCategories);
  }
}

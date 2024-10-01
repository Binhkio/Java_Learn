package com.luvina.la.controller;

import com.luvina.la.entity.Category;
import com.luvina.la.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Get all categories
     * @return List categories
     */
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    /**
     * Get category by Id
     * @param id of category
     * @return Category
     */
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Add new category
     * @param category New category
     */
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Update category's name
     * @param category New category
     */
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        Category oldCategory = categoryRepository.findById(category.getId()).orElse(null);
        assert oldCategory != null;
        oldCategory.setName(category.getName());
        return categoryRepository.save(oldCategory);
    }

    /**
     * Delete category
     * @param id of category
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}

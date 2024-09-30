package lvn.ecommerce.controller;

import lvn.ecommerce.entity.Category;
import lvn.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * Get all categories
     * @return List categories
     */
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    /**
     * Get category by Id
     * @param id of category
     * @return Category
     */
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    /**
     * Add new category
     * @param category New category
     */
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /**
     * Update category's name
     * @param category New category
     */
    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        Category oldCategory = categoryService.findById(category.getId());
        oldCategory.setName(category.getName());
        return categoryService.save(oldCategory);
    }

    /**
     * Delete category
     * @param id of category
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}

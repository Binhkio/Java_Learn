package lvn.ecommerce.service;

import lvn.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
    Category findById(Long id);
    void deleteById(Long id);
}

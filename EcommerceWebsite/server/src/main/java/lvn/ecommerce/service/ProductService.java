package lvn.ecommerce.service;

import lvn.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product findById(Long id);
    public List<Product> listAllProducts();
    void deleteById(Long id);
}

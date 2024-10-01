package com.luvina.la.controller;

import com.luvina.la.entity.Product;
import com.luvina.la.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products in database
     * @return List of products
     */
    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * Get product by Id
     * @param id Id of product
     * @return Product
     */
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Add a product to database
     * @param product New product receive from client
     */
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Add multiple products to database
     * @param products List of new products
     */
    @PostMapping("/adds")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return products.stream().map(product -> productRepository.save(product)).collect(Collectors.toList());
    }

    /**
     * Update product
     * @param product Overwrite product
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        Product oldProduct = productRepository.findById(product.getId()).orElse(null);
        assert oldProduct != null;
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setBrand(product.getBrand());
        oldProduct.setMadeIn(product.getMadeIn());
        return productRepository.save(oldProduct);
    }

    /**
     * Delete product by Id
     * @param id of product
     */
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

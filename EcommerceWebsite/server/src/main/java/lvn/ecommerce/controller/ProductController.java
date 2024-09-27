package lvn.ecommerce.controller;

import lvn.ecommerce.entity.Product;
import lvn.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Get all products in database
     * @return List of products
     */
    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> allProds = productService.listAllProducts();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
            headers.add("Access-Control-Allow-Credentials", "true");
            headers.add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(allProds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Get product by Id
     * @param id Id of product
     * @return Product
     */
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    /**
     * Add a product to database
     * @param product New product receive from client
     */
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    /**
     * Add multiple products to database
     * @param products List of new products
     */
    @PostMapping("/adds")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return products.stream().map(product -> productService.save(product)).collect(Collectors.toList());
    }

    /**
     * Update product
     * @param product Overwrite product
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        Product oldProduct = productService.findById(product.getId());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setBrand(product.getBrand());
        oldProduct.setMadein(product.getMadein());
        return productService.save(oldProduct);
    }

    /**
     * Delete product by Id
     * @param id of product
     */
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
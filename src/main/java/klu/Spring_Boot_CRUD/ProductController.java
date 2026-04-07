package klu.Spring_Boot_CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // CREATE
    @PostMapping
    public ResponseEntity<product> createProduct(@RequestBody product p) {
        product saved = service.saveProduct(p);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Optional<product> product = service.getProductById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody product p) {
        Optional<product> existing = service.getProductById(id);

        if (existing.isPresent()) {
            return ResponseEntity.ok(service.updateProduct(id, p));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Optional<product> existing = service.getProductById(id);

        if (existing.isPresent()) {
            service.deleteProduct(id);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product not found");
        }
    }
}
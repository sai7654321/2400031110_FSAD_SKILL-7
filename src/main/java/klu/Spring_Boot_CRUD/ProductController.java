package klu.Spring_Boot_CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5175")
public class ProductController {

    @Autowired
    private ProductService service;

    // 🔹 CREATE
    @PostMapping
    public product addProduct(@RequestBody product product) {
        return service.saveProduct(product);
    }

    // 🔹 READ ALL
    @GetMapping
    public List<product> getAllProducts() {
        return service.getAllProducts();
    }

    // 🔹 READ BY ID
    @GetMapping("/{id}")
    public Optional<product> getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public product updateProduct(@PathVariable int id, @RequestBody product product) {
        return service.updateProduct(id, product);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}
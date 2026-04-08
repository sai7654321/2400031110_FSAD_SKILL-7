package klu.Spring_Boot_CRUD;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import klu.jpql.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // CREATE
    public product saveProduct(product p) {
        return repo.save(p);
    }

    // READ ALL
    public List<product> getAllProducts() {
        return repo.findAll();
    }

    // READ BY ID
    public Optional<product> getProductById(int id) {
        return repo.findById(id);
    }

    // UPDATE
    public product updateProduct(int id, product p) {
        p.setId(id);
        return repo.save(p);
    }

    // DELETE
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

	public @Nullable Object getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public @Nullable Object update(int id, ProductService p) {
		// TODO Auto-generated method stub
		return null;
	}
}
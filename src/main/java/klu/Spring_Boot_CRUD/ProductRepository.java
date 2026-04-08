package klu.Spring_Boot_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

//import klu.jpql.Product;

public interface ProductRepository extends JpaRepository<product, Integer> {

	ProductService save(ProductService p);

}
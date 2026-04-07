package klu.Spring_Boot_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, Integer> {
}
package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Integer> {
}

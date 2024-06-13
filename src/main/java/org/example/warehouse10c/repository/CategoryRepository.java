package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

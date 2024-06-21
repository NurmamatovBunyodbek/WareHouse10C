package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesRepository extends JpaRepository<Supplier,Integer> {
}

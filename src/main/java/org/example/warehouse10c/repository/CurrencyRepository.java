package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}

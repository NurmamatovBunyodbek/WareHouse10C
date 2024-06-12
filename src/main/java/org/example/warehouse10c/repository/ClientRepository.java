package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}

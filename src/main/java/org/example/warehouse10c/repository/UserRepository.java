package org.example.warehouse10c.repository;

import org.example.warehouse10c.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

package com.example.springboothibernatecrud.repository;

import com.example.springboothibernatecrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

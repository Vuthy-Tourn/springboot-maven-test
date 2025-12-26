package com.example.springbootmaven.repository;

import com.example.springbootmaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}


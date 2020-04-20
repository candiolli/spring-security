package com.example.demospringsecurityoauth2.repository;

import com.example.demospringsecurityoauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
package com.example.demospringsecurityoauth2.repository;

import com.example.demospringsecurityoauth2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
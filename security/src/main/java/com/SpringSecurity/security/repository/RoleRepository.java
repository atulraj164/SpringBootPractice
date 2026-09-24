package com.SpringSecurity.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
   Optional<Role> findByrolename(String name);
}

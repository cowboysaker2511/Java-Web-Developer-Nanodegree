package com.example.mokito_demo.model.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mokito_demo.model.persistence.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

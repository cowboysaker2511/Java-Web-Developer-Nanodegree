package com.example.mokito_demo.model.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mokito_demo.model.persistence.Cart;
import com.example.mokito_demo.model.persistence.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByUser(User user);
}

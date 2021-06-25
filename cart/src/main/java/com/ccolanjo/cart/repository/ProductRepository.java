package com.ccolanjo.cart.repository;

import com.ccolanjo.cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

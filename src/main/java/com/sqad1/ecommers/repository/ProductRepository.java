package com.sqad1.ecommers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqad1.ecommers.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductNameContainingIgnoreCase(String productName);

}

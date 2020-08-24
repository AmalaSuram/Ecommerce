package com.sqad1.ecommers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqad1.ecommers.entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}

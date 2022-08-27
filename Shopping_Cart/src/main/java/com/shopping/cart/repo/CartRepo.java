package com.shopping.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.cart.entity.CartEntity;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer>{

}

package com.shopping.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.items.entity.CartEntity;


@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer>{

}

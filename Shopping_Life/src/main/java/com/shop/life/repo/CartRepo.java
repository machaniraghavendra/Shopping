package com.shop.life.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.life.entity.CartEntity;


@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer>{

}

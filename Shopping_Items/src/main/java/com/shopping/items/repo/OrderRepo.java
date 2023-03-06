package com.shopping.items.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.items.entity.OrderDetailsOfUser;

public interface OrderRepo extends JpaRepository<OrderDetailsOfUser, Integer> {

}

package com.shopping.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.items.entity.OrderDetailsOfUser;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetailsOfUser, Integer> {

}

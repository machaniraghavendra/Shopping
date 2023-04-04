package com.shopping.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.items.entity.ItemEntity;

@Repository
public interface ItemsRepo extends JpaRepository<ItemEntity, Integer> {

}

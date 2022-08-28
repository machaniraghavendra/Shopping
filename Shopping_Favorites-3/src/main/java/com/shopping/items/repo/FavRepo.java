package com.shopping.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.items.entity.FavouritesEntity;


@Repository
public interface FavRepo extends JpaRepository<FavouritesEntity, String>{

}

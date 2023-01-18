package com.shopping.favourites.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.favourites.entity.FavouritesEntity;

@Repository
public interface FavRepo extends JpaRepository<FavouritesEntity, Integer>{

}

package com.shopping.favourites.service;

import java.util.List;

import com.shopping.favourites.entity.FavouritesEntity;
import com.shopping.favourites.exception.ItemAlreadyInFavException;
import com.shopping.favourites.exception.ItemNotFoundInFavException;

public interface FavService {

	String save(FavouritesEntity favouritesEntity) throws ItemAlreadyInFavException;
	String update(FavouritesEntity favouritesEntity) throws ItemNotFoundInFavException;
	String delete(int favId) throws ItemNotFoundInFavException;
	FavouritesEntity find(int favId) throws ItemNotFoundInFavException;
	List<FavouritesEntity> viewall();
}

package com.shopping.items.service;

import java.util.List;

import com.shopping.items.entity.FavouritesEntity;
import com.shopping.items.exception.ItemAlreadyInFavException;
import com.shopping.items.exception.ItemNotFoundInFavException;

public interface FavService {

	String save(FavouritesEntity favouritesEntity) throws ItemAlreadyInFavException;
	String update(FavouritesEntity favouritesEntity) throws ItemNotFoundInFavException;
	String delete(String favId) throws ItemNotFoundInFavException;
	FavouritesEntity find(String favId) throws ItemNotFoundInFavException;
	List<FavouritesEntity> viewall();
}

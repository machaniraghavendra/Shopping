package com.shopping.items.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.items.entity.FavouritesEntity;
import com.shopping.items.exception.ItemAlreadyInFavException;
import com.shopping.items.exception.ItemNotFoundInFavException;
import com.shopping.items.repo.FavRepo;


@Service
public class FavServiceImpl implements FavService{

	@Autowired
	FavRepo favRepo;
	
	@Override
	public String save(FavouritesEntity favouritesEntity) throws ItemAlreadyInFavException {
		try {
			if(favRepo.existsById(favouritesEntity.getItemId()))
				throw new ItemAlreadyInFavException("The item "+favouritesEntity.getItemName()+" already in your favourites");
			else {
				favRepo.save(favouritesEntity);
				return "Added to your Wishlist";
			}
		} catch (ItemAlreadyInFavException e) {
			e.printStackTrace();
		}
		return "The item "+favouritesEntity.getItemName()+" already in your favourites";
	}

	@Override
	public String update(FavouritesEntity favouritesEntity) throws ItemNotFoundInFavException {
		try {
			if(!favRepo.existsById(favouritesEntity.getItemId()))
				throw new ItemNotFoundInFavException("The item "+favouritesEntity.getItemName()+" not exists in your Favourites");
			else {
				favRepo.save(favouritesEntity);
				return "Updated in your Wishlist";
			}
		} catch (ItemNotFoundInFavException e) {
			e.printStackTrace();
		}
		return "The item "+favouritesEntity.getItemName()+" not exists in your Favourites";
	}

	@Override
	public String delete(String favId) throws ItemNotFoundInFavException {
		FavouritesEntity favEntity=new FavouritesEntity();
		favEntity=favRepo.findById(favId).get();
		try {
			if(!favRepo.existsById(favId))
				throw new ItemNotFoundInFavException("The item "+favId+" not exists in your Favourites");
				else {
					favRepo.deleteById(favId);
					return "The item "+favEntity.getItemName()+" has been removed from your Favourites";
				}
		} catch (ItemNotFoundInFavException e) {
			e.printStackTrace();
		}
		return "The item "+favEntity.getItemName()+" not exists in your Favourites";
	}

	@Override
	public FavouritesEntity find(String favId) throws ItemNotFoundInFavException {
		try {
			if(!favRepo.existsById(favId))
				throw new ItemNotFoundInFavException("The item "+favId+" not exists in your Favourites");
			else {
				return favRepo.findById(favId).get();
			}
		} catch (ItemNotFoundInFavException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FavouritesEntity> viewall() {
		return favRepo.findAll(); 
	}
	
	public String total() {
		int amount=0;
		List<FavouritesEntity> list=favRepo.findAll();
		for (FavouritesEntity favEntity : list) {
			amount +=Integer.parseInt(favEntity.getItemPrice().substring(1,favEntity.getItemPrice().length()-3).replaceAll(",", "").trim());
		}
		NumberFormat format=NumberFormat.getCurrencyInstance(Locale.forLanguageTag("hi-IN"));
		
		return format.format(amount);
	}
}
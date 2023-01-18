package com.shopping.favourites.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.favourites.entity.FavouritesEntity;
import com.shopping.favourites.exception.ItemAlreadyInFavException;
import com.shopping.favourites.exception.ItemNotFoundInFavException;
import com.shopping.favourites.repo.FavRepo;

@Service
public class FavServiceImpl implements FavService{

	@Autowired
	FavRepo favRepo;
	private int i=1;
	@Override
	public String save(FavouritesEntity favouritesEntity) throws ItemAlreadyInFavException {
		try {
		    
		    List<FavouritesEntity> favList=favRepo.findAll().stream().
		            filter(a->a.getUserId().equalsIgnoreCase(favouritesEntity.getUserId()))
		            .filter(a->a.getItemName().equalsIgnoreCase(favouritesEntity.getItemName()))
		            .toList();
		    
			if(!favList.isEmpty())
				throw new ItemAlreadyInFavException("The item "+favouritesEntity.getItemName()+" already in your favourites");
			else {
			    FavouritesEntity favEntity=new FavouritesEntity(favouritesEntity.getItemId(),i++, favouritesEntity.getItemType(), favouritesEntity.getItemName(), favouritesEntity.getItemImgUrl(), favouritesEntity.getItemPrice(), favouritesEntity.getItemDesc(), favouritesEntity.getItemSpec(),favouritesEntity.getItemDimensions(),favouritesEntity.getUserId());
				favRepo.save(favEntity);
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
	public String delete(int favId) throws ItemNotFoundInFavException {
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
	public FavouritesEntity find(int favId) throws ItemNotFoundInFavException {
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
	
//	public String total() {
//		int amount=0;
//		List<FavouritesEntity> list=favRepo.findAll();
//		for (FavouritesEntity favEntity : list) {
//			amount +=Integer.parseInt(favEntity.getItemPrice().substring(1,favEntity.getItemPrice().length()-3).replaceAll(",", "").trim());
//		}
//		NumberFormat format=NumberFormat.getCurrencyInstance(Locale.forLanguageTag("hi-IN"));
//		
//		return format.format(amount);
//	}
}

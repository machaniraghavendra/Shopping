package com.shopping.items.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.items.entity.ItemEntity;
import com.shopping.items.exception.ItemAlreadyException;
import com.shopping.items.exception.ItemNotFoundException;
import com.shopping.items.repo.ItemsRepo;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemsRepo itemsRepo;
	
	@Override
	public String save(ItemEntity itemEntity) throws ItemAlreadyException {
		try {
			if(itemsRepo.existsById(itemEntity.getItemId()))
				throw new ItemAlreadyException("The item "+itemEntity.getItemName()+" already there");
			else {
				itemsRepo.save(itemEntity);
				return "Added !";
			}
		} catch (ItemAlreadyException e) {
			e.printStackTrace();
		}
		return "The item "+itemEntity.getItemName()+" already there";
	}

	@Override
	public String update(ItemEntity itemEntity) throws ItemNotFoundException {
		try {
			if(!itemsRepo.existsById(itemEntity.getItemId()))
				throw new ItemNotFoundException("The item "+itemEntity.getItemName()+" not exists");
			else {
				itemsRepo.save(itemEntity);
				return "Updated !";
			}
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
		return "The item "+itemEntity.getItemName()+" not exists";
	}

	@Override
	public String delete(int itemId) throws ItemNotFoundException {
		try {
			if(!itemsRepo.existsById(itemId))
				throw new ItemNotFoundException("The item "+itemId+" not exists ");
			else {
				itemsRepo.deleteById(itemId);
				return "The item "+itemId+" has been removed ";
			}
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
		return "The item "+itemId+" not exists ";
	}

	@Override
	public ItemEntity find(int itemId) throws ItemNotFoundException {
		try {
			if(!itemsRepo.existsById(itemId))
				throw new ItemNotFoundException("The item "+itemId+" not exists in your cart");
			else {
				return itemsRepo.findById(itemId).get();
			}
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ItemEntity> viewall() {
		return itemsRepo.findAll();
	}

	@Override
	@Transactional
	public String saveAll(List<ItemEntity> itemEntity) throws ItemAlreadyException{
		int val = 0;
		try {
			for (ItemEntity item : itemEntity) {
				val=item.getItemId();
				if(itemsRepo.existsById(item.getItemId()))
					throw new ItemAlreadyException("Already exists in data");
				else {
					itemsRepo.saveAll(itemEntity);
					return "Saved list of Items";
				}}
			}catch(ItemAlreadyException e) {
				e.printStackTrace();
			}
		return "Already "+val+" exists in data";
	}

	@Override
	public String deleteAll() {
		itemsRepo.deleteAll();
		return "Deleted the all Items";
	}

}

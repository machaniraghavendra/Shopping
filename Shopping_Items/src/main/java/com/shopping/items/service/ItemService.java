package com.shopping.items.service;

import java.util.List;

import com.shopping.items.entity.ItemEntity;
import com.shopping.items.exception.ItemAlreadyException;
import com.shopping.items.exception.ItemNotFoundException;

public interface ItemService {
	String save(ItemEntity itemEntity) throws ItemAlreadyException;
	String saveAll(List<ItemEntity> itemEntity) throws ItemAlreadyException;
	String update(ItemEntity itemEntity) throws ItemNotFoundException;
	String delete(int itemId) throws ItemNotFoundException;
	String deleteAll();
	List<Object> find(int itemId) throws ItemNotFoundException;
	List<ItemEntity> viewall();
}

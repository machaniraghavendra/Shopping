package com.shopping.items.service;

import java.util.List;

import com.shopping.items.entity.CartEntity;
import com.shopping.items.exception.ItemAlreadyInCartException;
import com.shopping.items.exception.ItemNotFoundInCartException;

public interface CartService {

	String save(CartEntity cartEntity) throws ItemAlreadyInCartException;
	String update(CartEntity cartEntity) throws ItemNotFoundInCartException;
	String delete(int cartId) throws ItemNotFoundInCartException;
	CartEntity find(int cartId) throws ItemNotFoundInCartException;
	List<CartEntity> viewall();
	
}
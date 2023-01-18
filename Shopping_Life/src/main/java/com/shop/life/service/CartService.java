package com.shop.life.service;

import java.util.List;

import com.shop.life.entity.CartEntity;
import com.shop.life.exception.ItemAlreadyInCartException;
import com.shop.life.exception.ItemNotFoundInCartException;

public interface CartService {

	String save(CartEntity cartEntity) throws ItemAlreadyInCartException;
	String update(CartEntity cartEntity) throws ItemNotFoundInCartException;
	String delete(int cartId) throws ItemNotFoundInCartException;
	CartEntity find(int cartId) throws ItemNotFoundInCartException;
	List<CartEntity> viewall();
	
}

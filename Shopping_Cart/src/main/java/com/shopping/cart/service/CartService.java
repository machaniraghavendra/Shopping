package com.shopping.cart.service;

import java.util.List;

import com.shopping.cart.entity.CartEntity;
import com.shopping.cart.exception.ItemAlreadyInCartException;
import com.shopping.cart.exception.ItemNotFoundInCartException;

public interface CartService {

	String save(CartEntity cartEntity) throws ItemAlreadyInCartException;
	String update(CartEntity cartEntity) throws ItemNotFoundInCartException;
	String delete(int cartId) throws ItemNotFoundInCartException;
	CartEntity find(int cartId) throws ItemNotFoundInCartException;
	List<CartEntity> viewall();
	
}

package com.shopping.cart.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.number.money.MonetaryAmountFormatter;
import org.springframework.stereotype.Service;

import com.shopping.cart.entity.CartEntity;
import com.shopping.cart.exception.ItemAlreadyInCartException;
import com.shopping.cart.exception.ItemNotFoundInCartException;
import com.shopping.cart.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepo cartRepo;

	@Override
	public String save(CartEntity cartEntity) throws ItemAlreadyInCartException{
		try {
			if(cartRepo.existsById(cartEntity.getItemId()))
				throw new ItemAlreadyInCartException("The item "+cartEntity.getItemName()+" already in your cart");
			else {
				cartRepo.save(cartEntity);
				return "Added to your cart";
			}
		} catch (ItemAlreadyInCartException e) {
			e.printStackTrace();
		}
		return "The item "+cartEntity.getItemName()+" already in your cart";
	}

	@Override
	public String update(CartEntity cartEntity) throws ItemNotFoundInCartException {
		try {
			if(!cartRepo.existsById(cartEntity.getItemId()))
				throw new ItemNotFoundInCartException("The item "+cartEntity.getItemName()+" not exists in your cart");
			else {
				cartRepo.save(cartEntity);
				return "Updated to your cart";
			}
		} catch (ItemNotFoundInCartException e) {
			e.printStackTrace();
		}
		return "The item "+cartEntity.getItemName()+" not exists in your cart";
	}

	@Override
	public String delete(int cartId) throws ItemNotFoundInCartException {
		CartEntity cartEntity=new CartEntity();
		cartEntity=cartRepo.findById(cartId).get();
		try {
			if(!cartRepo.existsById(cartId))
				throw new ItemNotFoundInCartException("The item "+cartEntity.getItemName()+" not exists in your cart");
				else {
					cartRepo.deleteById(cartId);
					return "The item "+cartEntity.getItemName()+" has been removed from your cart";
				}
		} catch (ItemNotFoundInCartException e) {
			e.printStackTrace();
		}
		return "The item "+cartId+" not exists in your cart";
	}

	@Override
	public CartEntity find(int cartId) throws ItemNotFoundInCartException{
		try {
			if(!cartRepo.existsById(cartId))
				throw new ItemNotFoundInCartException("The item "+cartId+" not exists in your cart");
			else {
				return cartRepo.findById(cartId).get();
			}
		} catch (ItemNotFoundInCartException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartEntity> viewall() {
		return cartRepo.findAll();
	}
	
	public String total() {
		int amount=0;
		List<CartEntity> list=cartRepo.findAll();
		for (CartEntity cartEntity : list) {
			amount +=Integer.parseInt(cartEntity.getItemPrice().substring(1,cartEntity.getItemPrice().length()-3).replaceAll(",", "").trim());
		}
		NumberFormat format=NumberFormat.getCurrencyInstance(Locale.forLanguageTag("hi-IN"));
		
		return format.format(amount);
	}
}

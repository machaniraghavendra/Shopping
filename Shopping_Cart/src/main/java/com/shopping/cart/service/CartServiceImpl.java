package com.shopping.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.entity.CartEntity;
import com.shopping.cart.exception.ItemAlreadyInCartException;
import com.shopping.cart.exception.ItemNotFoundInCartException;
import com.shopping.cart.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepo cartRepo;
    private int i=1;
    @Override
    public String save(CartEntity cartEntity) throws ItemAlreadyInCartException{

        try {
            List<CartEntity> listEntity=cartRepo.findAll().stream()
                    .filter(a->a.getUserId().equalsIgnoreCase(cartEntity.getUserId()))
                    .filter(a->a.getItemName().equalsIgnoreCase(cartEntity.getItemName()))
                    .toList();

            if (!listEntity.isEmpty()) {
                throw new ItemAlreadyInCartException("The item "+cartEntity.getItemName()+" already in your cart");
            }
            else {
                CartEntity cart=new CartEntity(cartEntity.getItemId(),i++, cartEntity.getItemType(), cartEntity.getItemName(), cartEntity.getItemImgUrl(), cartEntity.getItemPrice(), cartEntity.getItemDesc(), cartEntity.getItemSpec(),cartEntity.getItemDimensions(),cartEntity.getUserId());
                cartRepo.save(cart);
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

    //	public String total() {
    //		int amount=0;
    //		List<CartEntity> list=cartRepo.findAll();
    //		for (CartEntity cartEntity : list) {
    //			amount +=Integer.parseInt(cartEntity.getItemPrice().substring(1,cartEntity.getItemPrice().length()-3).replaceAll(",", "").trim());
    //		}
    //		NumberFormat format=NumberFormat.getCurrencyInstance(Locale.forLanguageTag("hi-IN"));
    //		System.out.println(amount);
    ////		return format.format(amount);
    //		return Integer.toString(amount);
    //	}
}

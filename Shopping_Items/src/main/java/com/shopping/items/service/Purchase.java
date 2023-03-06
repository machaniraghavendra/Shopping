package com.shopping.items.service;

import java.util.List;

import com.shopping.items.exception.ItemNotFoundException;

public interface Purchase {

	List<Object> buyNow(int itemId) throws ItemNotFoundException;
}

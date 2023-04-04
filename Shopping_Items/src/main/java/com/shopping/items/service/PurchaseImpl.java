package com.shopping.items.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.items.exception.ItemNotFoundException;

@Service
public class PurchaseImpl implements Purchase{

	@Autowired
	ItemServiceImpl itemServImpl;
	List<Object> value;
	
	@Override
	public List<Object> buyNow(int itemId) throws ItemNotFoundException {
			  value=itemServImpl.find(itemId);
			  return value;
	}
	
	public List<Object> getItem() {
		return value;
	}

}

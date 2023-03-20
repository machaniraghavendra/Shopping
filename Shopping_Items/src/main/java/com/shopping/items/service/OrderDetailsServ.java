package com.shopping.items.service;

import java.util.List;

import com.shopping.items.entity.OrderDetailsOfUser;
import com.shopping.items.exception.OrderNotFoundException;
import com.shopping.items.exception.OrderWithSameItemExistsException;

public interface OrderDetailsServ {

	List<Object> saveOrder(OrderDetailsOfUser orderDetailsOfUser) throws OrderWithSameItemExistsException;
	List<OrderDetailsOfUser> getAllOrders();
	List<Object> getOrderDetailsOfUser(int orderId) throws OrderNotFoundException;
}

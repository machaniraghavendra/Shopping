package com.shopping.items.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.items.entity.ItemEntity;
import com.shopping.items.entity.OrderDetailsOfUser;
import com.shopping.items.entity.UserDetails;
import com.shopping.items.exception.ItemNotFoundException;
import com.shopping.items.exception.ItemsExceptionHandler;
import com.shopping.items.exception.OrderNotFoundException;
import com.shopping.items.exception.OrderWithSameItemExistsException;
import com.shopping.items.repo.ItemsRepo;
import com.shopping.items.repo.OrderRepo;

@Service
public class OrderDetailsServImpl implements OrderDetailsServ{

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	ItemsRepo itemsRepo;

	@Autowired
	ItemServiceImpl  itemServiceImpl;

	@Autowired
	ItemsExceptionHandler itemExceptionHandler;

	@Override
	public List<Object> saveOrder(OrderDetailsOfUser orderDetailsOfUser) throws OrderWithSameItemExistsException{
		List<Object> value=new ArrayList<>();
		try {
			if (orderDetailsOfUser.getItemEntity() != null) {
				orderRepo.save(orderDetailsOfUser);
				value.add("Order placed");
			} else {
				throw new OrderWithSameItemExistsException("The same order placed already");
			}
		}
		catch (OrderWithSameItemExistsException e) {
			value.add(itemExceptionHandler.orderWithSameItemExistsException(e));
		}
		return value;
	}

	public List<Object> getUserAndItem(int ItemId,OrderDetailsOfUser orderDetailsOfUser) throws ItemNotFoundException, OrderWithSameItemExistsException {
		List<Object> itemEntity=itemServiceImpl.find(ItemId);
		orderDetailsOfUser=OrderDetailsOfUser.builder()
				.orderId(orderDetailsOfUser.getOrderId())
				.userDetails(orderDetailsOfUser.getUserDetails())
				.itemEntity(itemEntity)
				.firstName(orderDetailsOfUser.getFirstName())
				.lastName(orderDetailsOfUser.getLastName())
				.emailAddress(orderDetailsOfUser.getEmailAddress())
				.phoneNumber(orderDetailsOfUser.getPhoneNumber())
				.deliveryAddress(orderDetailsOfUser.getDeliveryAddress())
				.pincode(orderDetailsOfUser.getPincode())
				.paymentType(orderDetailsOfUser.getPaymentType())
				.orderQuantity(orderDetailsOfUser.getOrderQuantity())
				.orderedOn(LocalDate.now()).
				orderedAt(LocalTime.now()).build();

		return saveOrder(orderDetailsOfUser);
	}

	public List<OrderDetailsOfUser> getAllOrders(){
		return orderRepo.findAll();
	}
	
	List<Object> order=new ArrayList<>();

	@Override
	public List<Object> getOrderDetailsOfUser(int orderId) throws OrderNotFoundException {
		order=new ArrayList<>();
		try {
			if (orderRepo.existsById(orderId)) {
				order.add(orderRepo.findById(orderId).get());
			} else {
				throw new OrderNotFoundException("No order with id " + orderId);
			}
		} catch (OrderNotFoundException e) {
			order.add(itemExceptionHandler.orderNotFoundException(e));
		}
		return order;
	}
	
	public List<Object> getOrder(){
		return order;
	}
}

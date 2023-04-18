package com.shopping.items.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.items.entity.OrderDetailsOfUser;
import com.shopping.items.exception.ItemNotFoundException;
import com.shopping.items.exception.ItemsExceptionHandler;
import com.shopping.items.exception.OrderNotFoundException;
import com.shopping.items.exception.OrderWithSameItemExistsException;
import com.shopping.items.repo.ItemsRepo;
import com.shopping.items.repo.OrderRepo;

@Service
public class OrderDetailsServImpl implements OrderDetailsServ {

	private static final String STATUS_SUCCESS = "success";
	private static final String STATUS_DISPATCH = "dispatched";
	private static final String STATUS_NEARBYHUB = "near by hub";
	private static final String STATUS_CANCELLED = "cancelled";

	private List<Object> order = new ArrayList<>();

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ItemsRepo itemsRepo;

	@Autowired
	private ItemServiceImpl itemServiceImpl;

	@Autowired
	private ItemsExceptionHandler itemExceptionHandler;

	public List<Object> getUserAndItem(int ItemId, OrderDetailsOfUser orderDetailsOfUser)
			throws ItemNotFoundException, OrderWithSameItemExistsException {
		List<Object> itemEntity = itemServiceImpl.find(ItemId);
		orderDetailsOfUser = OrderDetailsOfUser.builder().orderId(orderDetailsOfUser.getOrderId())
				.uuidId(UUID.randomUUID()).userDetails(orderDetailsOfUser.getUserDetails()).itemEntity(itemEntity)
				.firstName(orderDetailsOfUser.getFirstName()).lastName(orderDetailsOfUser.getLastName())
				.emailAddress(orderDetailsOfUser.getEmailAddress()).phoneNumber(orderDetailsOfUser.getPhoneNumber())
				.deliveryAddress(orderDetailsOfUser.getDeliveryAddress()).pincode(orderDetailsOfUser.getPincode())
				.paymentType(orderDetailsOfUser.getPaymentType())
				.orderQuantity(orderDetailsOfUser.getOrderQuantity() == 0 ? 1 : orderDetailsOfUser.getOrderQuantity())
				.orderedOn(getDate(LocalDateTime.now())).orderedAt(getTime(LocalDateTime.now()))
				.deliveryDate(getDate(LocalDateTime.now().plusDays(5))).orderStatus(STATUS_SUCCESS).build();

		return saveOrder(orderDetailsOfUser);
	}

	@Override
	public List<Object> saveOrder(OrderDetailsOfUser orderDetailsOfUser) throws OrderWithSameItemExistsException {
		List<Object> value = new ArrayList<>();
		try {
			if (orderDetailsOfUser.getItemEntity() != null) {
				orderRepo.save(orderDetailsOfUser);
				value.add("Order placed");
			} else {
				throw new OrderWithSameItemExistsException("The same order placed already");
			}
		} catch (OrderWithSameItemExistsException e) {
			value.add(itemExceptionHandler.orderWithSameItemExistsException(e));
		}
		return value;
	}

	public List<Object> updateOrder(int orderId, String orderStatus) throws OrderNotFoundException {
		List<Object> value = new ArrayList<>();
		try {
			if (!Objects.isNull(orderStatus) && orderRepo.existsById(orderId)) {
				OrderDetailsOfUser orderDetailsOfUser = orderRepo.findById(orderId).get();
				switch (orderStatus.toLowerCase()) {
				case STATUS_SUCCESS:
					orderDetailsOfUser.setOrderStatus(STATUS_SUCCESS);
					break;
				case STATUS_DISPATCH:
					orderDetailsOfUser.setOrderStatus(STATUS_DISPATCH);
					break;
				case STATUS_NEARBYHUB:
					orderDetailsOfUser.setOrderStatus(STATUS_NEARBYHUB);
					break;
				case STATUS_CANCELLED:
					orderDetailsOfUser.setOrderStatus(STATUS_CANCELLED);
					break;
				}
				orderRepo.save(orderDetailsOfUser);
				value.add(orderDetailsOfUser);
			} else {
				throw new OrderNotFoundException("There is no order with id " + orderId);
			}
		} catch (OrderNotFoundException e) {
			value.add(itemExceptionHandler.orderNotFoundException(e));
		}
		return value;
	}

	public List<OrderDetailsOfUser> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public List<Object> getOrderDetailsOfUser(int orderId) throws OrderNotFoundException {
		order = new ArrayList<>();
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

	public List<Object> getOrder() {
		return order;
	}

	public String getDate(LocalDateTime date) {
		return date == null ? null
				: LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth())
						.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
	}

	public String getTime(LocalDateTime date) {
		return date == null ? null
				: LocalTime.of(date.getHour(), date.getMinute(), date.getSecond())
						.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

	public OrderDetailsOfUser getOrderDetailsWithUUID(UUID id) {
		return orderRepo.findAll().stream().filter(a -> a.getUuidId().equals(id)).findFirst().get();
	}

}

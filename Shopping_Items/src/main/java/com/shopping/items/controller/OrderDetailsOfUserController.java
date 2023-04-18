package com.shopping.items.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.items.entity.OrderDetailsOfUser;
import com.shopping.items.exception.ItemNotFoundException;
import com.shopping.items.exception.OrderNotFoundException;
import com.shopping.items.exception.OrderWithSameItemExistsException;
import com.shopping.items.service.OrderDetailsServImpl;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/orders/")
@Api(tags = "Order Details", description = "Gives all order data")
public class OrderDetailsOfUserController {

	@Autowired
	OrderDetailsServImpl orderDetailsServImpl;

	@PostMapping("/{orderId}")
	public ResponseEntity<List<Object>> saveOrder(@RequestBody OrderDetailsOfUser orderDetailsOfUser,
			@PathVariable int orderId) throws ItemNotFoundException, OrderWithSameItemExistsException {
		return ResponseEntity.ok(orderDetailsServImpl.getUserAndItem(orderId, orderDetailsOfUser));
	}

	@PutMapping("/updateOrder/{orderId}/{status}")
	public ResponseEntity<List<Object>> updateOrder(@PathVariable int orderId, @PathVariable String status) throws OrderNotFoundException {
		return ResponseEntity.ok(orderDetailsServImpl.updateOrder(orderId,status));
	}

	@GetMapping("/all")
	public ResponseEntity<List<OrderDetailsOfUser>> getAllOrders() {
		return ResponseEntity.ok(orderDetailsServImpl.getAllOrders());
	}

	@GetMapping("/")
	public ResponseEntity<List<Object>> getOrder() throws OrderNotFoundException {
		return ResponseEntity.ok(orderDetailsServImpl.getOrder());
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<List<Object>> getOrderDetailsOfUser(@PathVariable int orderId) throws OrderNotFoundException {
		return ResponseEntity.ok(orderDetailsServImpl.getOrderDetailsOfUser(orderId));
	}
	
}

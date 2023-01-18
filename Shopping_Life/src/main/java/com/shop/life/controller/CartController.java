package com.shop.life.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.life.entity.CartEntity;
import com.shop.life.exception.ItemAlreadyInCartException;
import com.shop.life.exception.ItemNotFoundInCartException;
import com.shop.life.service.CartServiceImpl;


@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

	@Autowired
	CartServiceImpl cartServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody CartEntity cartEntity) throws ItemAlreadyInCartException{
		return new ResponseEntity<String>(cartServiceImpl.save(cartEntity),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody CartEntity cartEntity) throws ItemNotFoundInCartException{
		return new ResponseEntity<String>(cartServiceImpl.update(cartEntity),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int cartId) throws ItemNotFoundInCartException{
		return new ResponseEntity<String>(cartServiceImpl.delete(cartId),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartEntity> find(@PathVariable("id") int cartId) throws ItemNotFoundInCartException{
		return new ResponseEntity<CartEntity>(cartServiceImpl.find(cartId),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CartEntity>> viewall(){
		return new ResponseEntity<List<CartEntity>>(cartServiceImpl.viewall(),HttpStatus.OK);
	}
	
	@GetMapping("/total")
	public String total() {
		return cartServiceImpl.total();
	}
}
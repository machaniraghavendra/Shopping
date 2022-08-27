package com.shopping.cart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartExceptionHandler {

	@ExceptionHandler(value=ItemNotFoundInCartException.class)
	public ResponseEntity<String> itemNotFoundInCartException(ItemNotFoundInCartException e){
		return new ResponseEntity<String>("Item not exists in cart",HttpStatus.OK);
	}
	
	@ExceptionHandler(value=ItemAlreadyInCartException.class)
	public ResponseEntity<String> itemAlreadyExistsInCartException(ItemAlreadyInCartException e){
		return new ResponseEntity<String>("Item already exists in cart",HttpStatus.OK);
	}
}

package com.shopping.items.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemsExceptionHandler {

	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<String> itemNotFoundException(ItemNotFoundException e){
		return new ResponseEntity<String>("Item not exists",HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(value=ItemAlreadyException.class)
	public ResponseEntity<String> itemAlreadyExistsException(ItemAlreadyException e){
		return new ResponseEntity<String>("Item already exists",HttpStatus.ACCEPTED);
	}
}

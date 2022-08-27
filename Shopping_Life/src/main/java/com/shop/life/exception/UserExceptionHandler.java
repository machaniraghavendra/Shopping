package com.shop.life.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> usernotfoundexception(UserNotFoundException e){
		return new ResponseEntity<String>("User not exists ",HttpStatus.OK);
	}
	
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<String> useralreadyexception(UserAlreadyExistsException e){
		return new ResponseEntity<String>("User already exists ",HttpStatus.OK);
	}
}

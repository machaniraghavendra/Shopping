package com.shopping.favourites.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FavouritesExceptionHandler {

		@ExceptionHandler(value=ItemNotFoundInFavException.class)
		public ResponseEntity<String> itemNotFoundInFavException(ItemNotFoundInFavException e){
			return new ResponseEntity<String>("Item not exists in favourites",HttpStatus.ACCEPTED);
		}
		
		@ExceptionHandler(value=ItemAlreadyInFavException.class)
		public ResponseEntity<String> itemAlreadyInFavException(ItemAlreadyInFavException e){
			return new ResponseEntity<String>("Item already exists in favourites",HttpStatus.ACCEPTED);
		}

}

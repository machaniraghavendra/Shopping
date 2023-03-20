package com.shopping.items.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderWithSameItemExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;

	private String thrownByMethod;

	private String[] thrownByMethodArgs;

	public OrderWithSameItemExistsException(String message) {
		super(message);
		statusCode=HttpStatus.INTERNAL_SERVER_ERROR;
	}
	public OrderWithSameItemExistsException(HttpStatus statusCode, String thrownByMethod, String[] thrownByMethodArgs) {
		super();
		this.statusCode = statusCode;
		this.thrownByMethod = thrownByMethod;
		this.thrownByMethodArgs = thrownByMethodArgs;
	}
	
}
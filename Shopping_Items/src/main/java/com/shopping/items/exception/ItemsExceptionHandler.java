package com.shopping.items.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemsExceptionHandler {
	private static final Log Logger=LogFactory.getLog(ItemNotFoundException.class);
	private static final Log Logger2=LogFactory.getLog(ItemAlreadyException.class);
	private static final Log Logger3=LogFactory.getLog(OrderWithSameItemExistsException.class);
	private static final Log Logger4=LogFactory.getLog(OrderNotFoundException.class);

	@ExceptionHandler(value=ItemNotFoundException.class)
	public ResponseEntity<TraceableError> itemNotFoundException(ItemNotFoundException e){
		if (e.getStatusCode()==null) {
			e.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TraceableError traceError=TraceableError.builder()
				.errorMessage(e.getMessage())
				.errorCode(String.valueOf(e.getStatusCode().value()))
				.exceptionType(e.getClass().getSimpleName())
				.errorDescription(e.getStatusCode().getReasonPhrase())
				.correlationId(MDC.get("correltionId"))
				.build();
		return new ResponseEntity<>(traceError,e.getStatusCode());
	}
	
	@ExceptionHandler(value=ItemAlreadyException.class)
	public ResponseEntity<TraceableError> itemAlreadyExistsException(ItemAlreadyException e){
		if (e.getStatusCode()==null) {
			e.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TraceableError traceError=TraceableError.builder()
				.errorMessage(e.getMessage())
				.errorCode(String.valueOf(e.getStatusCode().value()))
				.exceptionType(e.getClass().getSimpleName())
				.errorDescription(e.getStatusCode().getReasonPhrase())
				.correlationId(MDC.get("correltionId"))
				.build();
		return new ResponseEntity<>(traceError,e.getStatusCode());
	}
	
	@ExceptionHandler(value=OrderWithSameItemExistsException.class)
	public ResponseEntity<TraceableError> orderWithSameItemExistsException(OrderWithSameItemExistsException e){
		if (e.getStatusCode()==null) {
			e.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TraceableError traceError=TraceableError.builder()
				.errorMessage(e.getMessage())
				.errorCode(String.valueOf(e.getStatusCode().value()))
				.exceptionType(e.getClass().getSimpleName())
				.errorDescription(e.getStatusCode().getReasonPhrase())
				.correlationId(MDC.get("correltionId"))
				.build();
		return new ResponseEntity<>(traceError,e.getStatusCode());
	}
	
	@ExceptionHandler(value=OrderNotFoundException.class)
	public ResponseEntity<TraceableError> orderNotFoundException(OrderNotFoundException e){
		if (e.getStatusCode()==null) {
			e.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TraceableError traceError=TraceableError.builder()
				.errorMessage(e.getMessage())
				.errorCode(String.valueOf(e.getStatusCode().value()))
				.exceptionType(e.getClass().getSimpleName())
				.errorDescription(e.getStatusCode().getReasonPhrase())
				.correlationId(MDC.get("correltionId"))
				.build();
		return new ResponseEntity<>(traceError,e.getStatusCode());
	}
}

package com.example.sorapi.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {
	
	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(InvalidOrderException e) {
		
		ErrorResponse response = new ErrorResponse("INVALID_ORDER", e.getMessage());
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException e) {
		
		ErrorResponse response = new ErrorResponse("ORDER_NOT_FOUND", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}

package com.example.sorapi.order;

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
}

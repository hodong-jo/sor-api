package com.example.sorapi.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sorapi.domain.order.exception.DuplicateOrderException;
import com.example.sorapi.domain.order.exception.InvalidOrderException;
import com.example.sorapi.domain.order.exception.InvalidOrderSearchException;
import com.example.sorapi.domain.order.exception.InvalidOrderStatusTransitionException;
import com.example.sorapi.domain.order.exception.OrderNotFoundException;
import com.example.sorapi.global.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handlerValidationException(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		
		ErrorResponse response = new ErrorResponse("VALIDATION_ERROR", message);
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(InvalidOrderSearchException.class)
	public ResponseEntity<ErrorResponse> handleInvalidOrderException(InvalidOrderSearchException e){
		
		ErrorResponse response = new ErrorResponse("INVALID_ORDER_SERCH", e.getMessage());
		
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(InvalidOrderStatusTransitionException.class)
	public ResponseEntity<ErrorResponse> handleInvalidOrderStatusTransitionException(InvalidOrderStatusTransitionException e){
		
		ErrorResponse response = new ErrorResponse("INVALID_STATUS_TRANSITION", e.getMessage());
		
		return ResponseEntity.badRequest().body(response);
	}
	
	
	@ExceptionHandler(DuplicateOrderException.class)
	public ResponseEntity<ErrorResponse> duplicateOrderException(DuplicateOrderException e){
		
		ErrorResponse response = new ErrorResponse("DUPLICATE_ORDER", e.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}
	
}

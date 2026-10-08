package com.example.sorapi.order;

public class InvalidOrderException extends RuntimeException{
	
	public InvalidOrderException(String message) {
		super(message);
	}

}

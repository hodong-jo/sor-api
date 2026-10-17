package com.example.sorapi.domain.order.exception;

public class DuplicateOrderException extends RuntimeException{
	
	public DuplicateOrderException(String orderId) {
		super("이미 등록된 주문입니다. orderId = " + orderId);
	}

}

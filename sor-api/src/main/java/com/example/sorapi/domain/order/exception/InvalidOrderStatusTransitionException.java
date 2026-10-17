package com.example.sorapi.domain.order.exception;

import com.example.sorapi.domain.order.OrderStatus;

public class InvalidOrderStatusTransitionException extends RuntimeException{

	public InvalidOrderStatusTransitionException(OrderStatus currentStatus, OrderStatus newStatus) {
		super("허용되지 않은 주문상태 변경입니다." + currentStatus + " -> " + newStatus);
	}
}

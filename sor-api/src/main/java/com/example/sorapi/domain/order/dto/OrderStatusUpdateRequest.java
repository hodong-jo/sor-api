package com.example.sorapi.domain.order.dto;

import com.example.sorapi.domain.order.OrderStatus;

import jakarta.validation.constraints.NotNull;

public class OrderStatusUpdateRequest {
	
	@NotNull(message = "변경할 주문 상태는 필수입니다.")
	private OrderStatus status;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
}

package com.example.sorapi.domain.routing;

import org.springframework.stereotype.Component;

import com.example.sorapi.domain.order.Order;

@Component
public class MockBrokerAdapter {
	
	public RoutingResult sendOrder(Order order) {
		
		if(order.getQuantity() <= 0 || order.getPrice() <= 0) {
			return new RoutingResult(false, "수량 또는 가격이 올바르지 않습니다.");
		}
		
		return new RoutingResult(true, "모의 외부 시스템이 주문을 접수 했습니다.");
	}

}

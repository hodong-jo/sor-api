package com.example.sorapi.domain.routing;

import org.springframework.stereotype.Service;

import com.example.sorapi.domain.order.Order;

@Service
public class OrderRoutingService {
	
	private final MockBrokerAdapter mockBrokerAdapter;
	
	public OrderRoutingService(MockBrokerAdapter mockBrokerAdapter) {
		this.mockBrokerAdapter = mockBrokerAdapter;
	}

	public RoutingTarget selectTarget(Order order) {
		if(order.getSymbol() == null || order.getSymbol().isBlank()) {
			throw new IllegalArgumentException("종목 코드는 필수입니다.");
		}
		
		return RoutingTarget.MOCK_BROKER;
	}
	
	public RoutingResult routerOrder(Order order) {
		RoutingTarget target = selectTarget(order);
		
		if(target == RoutingTarget.MOCK_BROKER) {
			return mockBrokerAdapter.sendOrder(order);
		}
		
		return new RoutingResult(false, "지원하지 않는 라우팅 대상입니다.");
	}
}

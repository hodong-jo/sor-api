package com.example.sorapi.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderValidator orderValidator;

	public OrderService(OrderRepository orderRepository, OrderValidator orderValidator) {
		this.orderRepository = orderRepository;
		this.orderValidator = orderValidator;
	}

	public void createOrder(OrderCreateRequest request) {

		Order order = new Order(request.getOrderId(), request.getSymbol(), request.getQuantity(), request.getPrice());

		ValidationResult result = orderValidator.validate(order);
		
		if (!result.isValid()) {
			throw new InvalidOrderException(result.getMessage());
		}
		
		order.setStatus(OrderStatus.RECEIVED);
		
		orderRepository.save(order);

	}

}

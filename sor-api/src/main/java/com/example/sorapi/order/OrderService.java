package com.example.sorapi.order;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderValidator orderValidator;

	public OrderService(OrderRepository orderRepository, OrderValidator orderValidator) {
		this.orderRepository = orderRepository;
		this.orderValidator = orderValidator;
	}

	public Order createOrder(OrderCreateRequest request) {

		Order order = new Order(request.getOrderId(), request.getSymbol(), request.getQuantity(), request.getPrice());

		ValidationResult result = orderValidator.validate(order);
		
		if (!result.isValid()) {
			throw new InvalidOrderException(result.getMessage());
		}
		
		order.setStatus(OrderStatus.RECEIVED);
		
		return orderRepository.save(order); 
	}
	
	public List<Order> getOrderByPriceRange(int minPrice, int maxPrice) {
		return orderRepository.findByPriceBetween(minPrice, maxPrice);
	}
	
	public Order getOrder(String orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
	}
	
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	
	public List<Order> getOrdersBysymbol(String symbol){
		return orderRepository.findBySymbol(symbol);
	}
	
	public void deleteOrder(String orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
		orderRepository.delete(order);
	}
	

}

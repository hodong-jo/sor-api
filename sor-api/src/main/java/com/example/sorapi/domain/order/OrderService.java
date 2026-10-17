package com.example.sorapi.domain.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sorapi.domain.order.dto.OrderCreateRequest;
import com.example.sorapi.domain.order.exception.DuplicateOrderException;
import com.example.sorapi.domain.order.exception.InvalidOrderException;
import com.example.sorapi.domain.order.exception.InvalidOrderStatusTransitionException;
import com.example.sorapi.domain.order.exception.OrderNotFoundException;
import com.example.sorapi.domain.routing.OrderRoutingService;
import com.example.sorapi.domain.routing.RoutingResult;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderValidator orderValidator;
	private final OrderRoutingService orderRoutingService;

	public OrderService(OrderRepository orderRepository, OrderValidator orderValidator, OrderRoutingService orderRoutingService) {
		this.orderRepository = orderRepository;
		this.orderValidator = orderValidator;
		this.orderRoutingService = orderRoutingService;
	}

	public Order createOrder(OrderCreateRequest request) {
		
		if(orderRepository.existsById(request.getOrderId())) {
			throw new DuplicateOrderException(request.getOrderId());
		}

		Order order = new Order(request.getOrderId(), request.getSymbol(), request.getQuantity(), request.getPrice());

		ValidationResult result = orderValidator.validate(order);
		
		if (!result.isValid()) {
			throw new InvalidOrderException(result.getMessage());
		}
		
		order.setStatus(OrderStatus.VALIDATED);
		
		// 검증이 끝난 주문 저장
		Order savedOrder = orderRepository.save(order);
		
		// 외부 시스템으로 라우팅
		return routeOrder(savedOrder.getOrderId()); 
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
	
	public Order updateOrderStatus(String orderId, OrderStatus newStatus) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
		
		OrderStatus currentStatus = order.getStatus();
		
		boolean allowed = (currentStatus == OrderStatus.RECEIVED && (newStatus == OrderStatus.VALIDATED || newStatus == OrderStatus.REJECTED))
				|| (currentStatus == OrderStatus.VALIDATED && (newStatus == OrderStatus.ROUTED || newStatus == OrderStatus.REJECTED))
				|| (currentStatus == OrderStatus.ROUTED && (newStatus == OrderStatus.COMPLETED || newStatus == OrderStatus.REJECTED));
		
		if(!allowed) {
			throw new InvalidOrderStatusTransitionException(currentStatus, newStatus);
		}
				
		
		order.setStatus(newStatus);
		
		return orderRepository.save(order);
	}
	
	public Order routeOrder(String orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));

		if(order.getStatus() != OrderStatus.VALIDATED) {
			throw new InvalidOrderStatusTransitionException(order.getStatus(), OrderStatus.ROUTED);
		}
		
		RoutingResult result = orderRoutingService.routerOrder(order);
		
		if (result.isSuccess()) {
			return updateOrderStatus(orderId, OrderStatus.ROUTED);
		}
		
		return updateOrderStatus(orderId, OrderStatus.REJECTED);
	}

}

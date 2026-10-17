package com.example.sorapi.domain.order;

import java.net.Authenticator.RequestorType;
import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sorapi.domain.order.dto.OrderCreateRequest;
import com.example.sorapi.domain.order.dto.OrderStatusUpdateRequest;
import com.example.sorapi.domain.order.exception.InvalidOrderSearchException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController (OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderCreateRequest request) {
		Order order = orderService.createOrder(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	@PostMapping("/{orderId}/route")
	public Order routeOrder(@PathVariable String orderId) {
		return orderService.routeOrder(orderId);
	}
	
	
	@GetMapping("/price-range")
	public List<Order> getOrdersByPriceRange(@RequestParam int minPrice, 
											@RequestParam int maxPrice) {
		if(minPrice > maxPrice) {
			throw new InvalidOrderSearchException("최소 가격은 최대 가격보다 클 수 없습니다.");
		}
		
		return orderService.getOrderByPriceRange(minPrice, maxPrice);
	}
	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}
	
	@GetMapping
	public List<Order> getOrders(@RequestParam(required = false) String symbol) {
		if(symbol == null || symbol.isBlank()) {
			return orderService.getOrders();
		}
		
		return orderService.getOrdersBysymbol(symbol);
	}
	
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
		orderService.deleteOrder(orderId);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@PatchMapping("/{orderId}/status")
	public Order updateOrderStatus(@PathVariable String orderId, 
									@Valid @RequestBody OrderStatusUpdateRequest request) {
		
		return orderService.updateOrderStatus(orderId, request.getStatus());
	}
	
	
}

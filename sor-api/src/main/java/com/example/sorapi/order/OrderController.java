package com.example.sorapi.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController (OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public String createOrder(@RequestBody OrderCreateRequest request) {
		orderService.createOrder(request);
		
		return "주문 접수 완료";
	}
	
	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable String orderId) {
		return orderService.getOrder(orderId);
	}

}

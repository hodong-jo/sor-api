package com.example.sorapi.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController (OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/orders")
	public String createOrder(@RequestBody OrderCreateRequest request) {
		
		orderService.createOrder(request);
		
		return "주문 접수 완료";
	}

}

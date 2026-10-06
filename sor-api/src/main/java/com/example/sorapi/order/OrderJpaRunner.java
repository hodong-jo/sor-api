package com.example.sorapi.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderJpaRunner implements CommandLineRunner{
	
	private final OrderRepository orderRepository;
	
	public OrderJpaRunner(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Order order = new Order("ORD-003", "035420", 20, 250000);
		
		orderRepository.save(order);
		
		System.out.println("주문 저장 완료");
	}

}

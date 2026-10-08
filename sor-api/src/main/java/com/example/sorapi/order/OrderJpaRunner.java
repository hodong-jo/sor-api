package com.example.sorapi.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
public class OrderJpaRunner implements CommandLineRunner{
	
	private final OrderService orderService;
	
	public OrderJpaRunner(OrderService orderService) {
		this.orderService = orderService;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
//		orderService.createOrder();
		
//		System.out.println("주문 생성 완료!");
		
//		List<Order> orders = orderRepository.searchOrder("035422", 100);
//		
//		for(Order item : orders) {
//			System.out.println(item.getOrderId() + " / " + item.getSymbol() + " / " +  item.getQuantity() + "주 / " + item.getPrice() + "원");
//		}
		
//		Order foundOrder = orderRepository.findById("ORD-003").get();
		
//		System.out.println(foundOrder.getOrderId() + " / " + foundOrder.getSymbol() + " / " +  foundOrder.getQuantity() + "주 / " + foundOrder.getPrice() + "원");
		
//		foundOrder.setPrice(15000);
		
//		orderRepository.save(foundOrder);
		
//		System.out.println(foundOrder.getOrderId() + " / " + foundOrder.getSymbol() + " / " +  foundOrder.getQuantity() + "주 / " + foundOrder.getPrice() + "원");
		
		
//		List<Order> orders = orderRepository.findAll();
		
//		for (Order item : orders) {
//			System.out.println(item.getOrderId() + " / " + item.getSymbol() + " / " +  item.getQuantity() + "주 / " + item.getPrice() + "원");
//		}
		
		
//		Optional<Order> result = orderRepository.findById("ORD-003");
//		
//		orderRepository.deleteById("ORD-003");
//		
//		if (result.isPresent()) {
//			Order foundOrder = result.get();
//			
//			System.out.println(
//					foundOrder.getOrderId() + " / " 
//					+ foundOrder.getSymbol() + " / " 
//					+ foundOrder.getQuantity() + "주 / " 
//					+ foundOrder.getPrice() + "원");
//		} else {
//			System.out.println("주문을 찾을 수 없습니다.");
//		}
		
		
		
	}

}

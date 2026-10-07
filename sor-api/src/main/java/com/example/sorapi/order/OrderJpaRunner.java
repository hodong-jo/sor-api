package com.example.sorapi.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderJpaRunner implements CommandLineRunner{
	
	private final OrderRepository orderRepository;
	
	public OrderJpaRunner(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		List<Order> orderList = new ArrayList<>();
		orderList.add(new Order("ORD-003", "035422", 20, 250000));
		orderList.add(new Order("ORD-004", "035422", 25, 100000));
		orderList.add(new Order("ORD-005", "035422", 30, 700000));
		
		orderRepository.saveAll(orderList);
		
		System.out.println("주문 저장 완료");
		
		List<Order> orders = orderRepository.searchOrder("035422", 100);
		
		for(Order item : orders) {
//			System.out.println(item.getOrderId() + " / " + item.getSymbol() + " / " +  item.getQuantity() + "주 / " + item.getPrice() + "원");
		}
		
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

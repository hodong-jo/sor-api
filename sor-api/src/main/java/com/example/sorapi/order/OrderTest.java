package com.example.sorapi.order;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

	public static void main(String[] args) {
		
		
		Order order1 = new Order("DRD-001", "005930", 10, 70000);
		Order order2 = new Order("DRD-002", "000660", 5, 150000);
		Order order3 = new Order("", "035420", 20, 200000);
		Order order4 = new Order("ORD-004", "051910", 15, 350000);
		
		List<Order> orders = new ArrayList<>();
			
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		
		OrderValidator validator = new OrderValidator();
		
		List<ValidationResult> results = validator.validateAll(orders);
		
		for (ValidationResult result : results) {
			System.out.println(result.isValid() + " / " + result.getMessage());
		}
		
		
//		
//		System.out.println("갯수 : " + orders.size());
//		
//		for(Order order : orders) {
//			System.out.print(orderValidator.validate(order).getMessage() + " : ");
//			System.out.println(order.getOrderId() + " / "
//					+ order.getSymbol() + " / "
//					+ order.getQuantity() + "주 / "
//					+ order.getPrice() + "원");
//		}
		
	}

}

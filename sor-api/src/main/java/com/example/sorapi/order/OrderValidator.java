package com.example.sorapi.order;

import java.util.List;
import java.util.ArrayList;

public class OrderValidator {

	public ValidationResult validate(Order order) {
		if(order.getOrderId() == null || order.getOrderId().isBlank()) {
			return new ValidationResult(false, "주문 ID가 없습니다.");
		}
		
		if(order.getSymbol() == null || order.getSymbol().isBlank()) {
			return new ValidationResult(false, "종목 코드가 없습니다.");
		}
		
		if(order.getQuantity() <= 0) {
			return new ValidationResult(false, "주문수량은 0보다 커야 합니다.");
		}
		
		if(order.getPrice() <= 0) {
			return new ValidationResult(false, "주문가격은 0보다 커야 합니다.");
		}
		
		return new ValidationResult(true, "정상 주문입니다.");
	}
	
	public List<ValidationResult> validateAll(List<Order> orders){
		
		List<ValidationResult> results= new ArrayList<>();
		
		for(Order order : orders) {
			ValidationResult validationResult = validate(order);
			results.add(validationResult);
		}
		
		return results;
	}
	
}

package com.example.sorapi.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderCreateRequest {
	
	@NotBlank(message = "주문 ID는 필수입니다.")
	private String orderId;
	
	@NotBlank(message = "종목 코드는 필수입니다")
	private String symbol;
	
	@Min(value = 1, message = "주문 수량은 1 이상이어야 합니다.")
	private int quantity;
	
	@Min(value = 1, message = "주문 가격은 1 이상이어야 합니다.")
	private int price;
	
	
	public String getOrderId() {
		return orderId;
	}
	public String getSymbol() {
		return symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}

}

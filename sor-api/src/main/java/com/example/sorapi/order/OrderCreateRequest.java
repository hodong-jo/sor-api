package com.example.sorapi.order;

public class OrderCreateRequest {
	
	private String orderId;
	private String symbol;
	private int quantity;
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

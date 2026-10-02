package com.example.sorapi.order;

public class Order {
	
	private String orderId;
	private String symbol;
	private int quantity;
	private int price;
	
	public Order() {
	}
	
	public Order(String orderId, String symbol, int quantity, int price) {
		this.orderId = orderId;
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}

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

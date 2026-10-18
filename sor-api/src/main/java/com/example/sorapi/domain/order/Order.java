package com.example.sorapi.domain.order;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	private String orderId;
	private String symbol;
	private int quantity;
	private int price;
	private LocalDateTime orderTime;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@PrePersist
	public void prePersist() {
		this.orderTime = LocalDateTime.now();
	}
	
	
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
	
	public OrderStatus getStatus() {
		return status;
	}

	public LocalDateTime getOrderTime() {
        return orderTime;
    }
	
	
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}

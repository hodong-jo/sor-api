package com.example.sorapi.domain.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class OrderJdbcRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		Order order = new Order("ORD-003", "035422", 20, 250000);
		
		order.setStatus(OrderStatus.RECEIVED);
		
		System.out.println(
				order.getOrderId() + " / "
				+ order.getStatus()
//				+ order.getSymbol() + " / " 
//				+  order.getQuantity() + "주 / " 
//				+ order.getPrice() + "원"
		);
		
		
		String url = "jdbc:h2:mem:sordb";
		String username = "sa";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
		
		while(resultSet.next()) {
			String orderId = resultSet.getString("order_id");
			String symbol  = resultSet.getString("symbol");
			int quantity = resultSet.getInt("quantity");
			int price = resultSet.getInt("price");
			
			System.out.println(orderId + " / " + symbol + " / " + quantity + "주 / " + price + "원"); 
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}

}

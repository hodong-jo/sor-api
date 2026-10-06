package com.example.sorapi.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderJdbcRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
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
			
			System.out.println(orderId + " / " + symbol + " / " + price + "주 / " + quantity + "원"); 
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}

}

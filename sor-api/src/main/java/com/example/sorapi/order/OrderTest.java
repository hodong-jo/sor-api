package com.example.sorapi.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderTest {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:h2:mem:sordb";
		String username = "sa";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS");
		
		while(resultSet.next()) {
			String orderId = resultSet.getString("order_id");
			String symbol  = resultSet.getString("symbol");
			int quantity = resultSet.getInt("quantity");
			int price = resultSet.getInt("price");
			
			System.out.println(orderId + " / " + symbol + " / " + price + "주 / " + quantity + "원"); 
		}
		
		
		List<Order> orders = new ArrayList<Order>();
		
		orders.add(new Order("ORD-001", "005930", 10, 70000));
		orders.add(new Order("ORD-002", "000660", 5, 150000));
		orders.add(new Order("ORD-003", "005930", 20, 71000));
		orders.add(new Order("ORD-004", "035420", 7, 200000));
		orders.add(new Order("ORD-005", "005930", 15, 70500));
		
		Map<String, List<Order>> orderBySymbol = new HashMap<String, List<Order>>();
		
		for(Order order : orders) {
			String symbol = order.getSymbol();
			
			List<Order> orderForSymbol = orderBySymbol.computeIfAbsent(symbol, key -> new ArrayList<Order>());
			
//			List<Order> orderForSymbol = orderBySymbol.get(symbol);
			
//			if(orderForSymbol == null) {
//				orderForSymbol = new ArrayList<Order>();
//				
//				orderBySymbol.put(symbol, orderForSymbol);
//			}
//			
			orderForSymbol.add(order);
		}
		
		  for(Map.Entry<String, List<Order>> entry : orderBySymbol.entrySet()) {
			  String symbol = entry.getKey();
		  
			  System.out.println("종목 : " + symbol);
		  
			  for(Order order : entry.getValue()) {
				  System.out.println("주문: " + order.getOrderId() + " / " + order.getOrderId() + "주 / " + order.getOrderId() + "원"); 
			  }
		  }
		  
		  resultSet.close();
		  statement.close();
		  connection.close();
	}

}

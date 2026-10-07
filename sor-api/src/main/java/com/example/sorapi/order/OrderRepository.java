package com.example.sorapi.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, String>{
	
	List<Order> findBySymbol(String symbol);
	
	List<Order> findByOrderIdAndSymbol(String orderId, String symbol);

	List<Order> findByPriceGreaterThan(int price);

	List<Order> findBySymbolAndPriceGreaterThanOrderByPriceDesc(String symbol, int price);
	
	@Query("SELECT o FROM Order o WHERE o.price BETWEEN :minPrice AND :maxPrice")
	List<Order> findByPriceBetween(int minPrice, int maxPrice);
	
	@Query("""
			SELECT o 
			FROM Order o
			WHERE o.symbol = :symbol
			  AND o.price > :price
			ORDER BY o.price DESC
			""")
	List<Order> searchOrder(
			@Param("symbol") String symbol, 
			@Param("price") int price
	);
	
	
}

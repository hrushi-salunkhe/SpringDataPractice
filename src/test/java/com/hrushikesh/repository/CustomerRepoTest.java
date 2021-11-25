package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Customer;
import com.hrushikesh.model.Order;
import com.hrushikesh.model.Product;

@SpringBootTest
class CustomerRepoTest {

	@Autowired
	CustomerRepo repo;
	
	@Test
	@Disabled
	void test() {
		Order order1 = Order.builder()
		.orderId(1)
		.name("one")
		.address("One Drive")
		.build();
		
		Order order2 = Order.builder()
				.orderId(2)
				.name("two")
				.address("Two Drive")
				.build();
		
		Order order3 = Order.builder()
				.orderId(3)
				.name("three")
				.address("Three Drive")
				.build();
		
		List<Order> list = new ArrayList<Order>();
		
		list.add(order1); list.add(order2); list.add(order3);
		
		Customer customer = Customer.builder()
		.customerId(1)
		.name("A")
		.address("A drive")
//		.orders(list)
		.build();
		
		this.repo.save(customer);
	}

	@Test
	void testManyToMany() {
		Product product1 = Product.builder().productId(901).productName("Sofa").build();
		Product product2 = Product.builder().productId(902).productName("Bed").build();
		Product product3 = Product.builder().productId(903).productName("Table").build();
		
		List<Product> list = new ArrayList<Product>();
		
		list.add(product1);
		list.add(product2);
		list.add(product3);
		
		Customer customer = Customer.builder().customerId(902).name("Oldemort").address("Hogwarts").build();
		
		this.repo.save(customer);
		
	}
}

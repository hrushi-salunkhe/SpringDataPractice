package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Customer;
import com.hrushikesh.model.Order;

@SpringBootTest
class OrderRepoTest {

	@Autowired
	OrderRepo repo;

	@Test
	void test() {
		Customer customer = Customer.builder().customerId(50).address("Pune").name("KJ").build();

		Order order1 = Order.builder().orderId(14).name("phone").address("Pune").customer(customer).build();

		Order order2 = Order.builder().orderId(15).name("helmet").address("Pune").customer(customer).build();

		Order order3 = Order.builder().orderId(16).name("juice").address("Pune").customer(customer).build();

		List<Order> list = new ArrayList<Order>();
		
		list.add(order1); list.add(order2); list.add(order3);
		
		this.repo.saveAll(list);

	}

}

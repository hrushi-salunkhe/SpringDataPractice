package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Customer;
import com.hrushikesh.model.Product;

@SpringBootTest( )
class ProductRepoTest {
	
	@Autowired ProductRepo repo;

	@Test
	void test() {
		Customer customer1 = Customer.builder().customerId(903).name("Harry").address("Whinging").build();
		Customer customer2 = Customer.builder().customerId(902).name("Oldemort").address("Hogwarts").build();
		
		List<Customer> listCustomer = new ArrayList<>();
		
		listCustomer.add(customer1);
		listCustomer.add(customer2);
		
		
		Product product1 = Product.builder().productId(905).productName("Wand").build();
		
		listCustomer = new ArrayList<>();
		listCustomer.add(customer1);
		
		Product product2 = Product.builder().productId(906).productName("Owl").build();
		
		listCustomer = new ArrayList<>();
		listCustomer.add(customer2);
		
		
		Product product3 = Product.builder().productId(907).productName("Curse").build();
		
		List<Product> listProduct = new ArrayList<Product>();
		
		listProduct.add(product1);
		listProduct.add(product2);
		listProduct.add(product3);
		
		this.repo.saveAll(listProduct);
	}

}

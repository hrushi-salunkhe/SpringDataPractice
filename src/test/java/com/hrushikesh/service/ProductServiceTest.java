package com.hrushikesh.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hrushikesh.model.Product;
import com.hrushikesh.repository.ProductRepo;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepo productRepo;
	
	@BeforeEach()
	void setUp() {
		Product product = Product.builder().productId(2).productName("test product").build();
		
		Mockito.when(this.productService.getProduct("test"))
			.thenReturn(product);
		
	}
	
	@Test
	@DisplayName("Test: Search products containing the keyword")
	void testGetProduct() {
		
		Product product = this.productService.getProduct("test");
		System.out.println(product);
		
		Product product2 = Product.builder().productId(2).productName("test product").build();
		
		assertThat(product).hasNoNullFieldsOrPropertiesExcept("customers");
	}

}

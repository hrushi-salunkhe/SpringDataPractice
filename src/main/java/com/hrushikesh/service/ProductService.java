package com.hrushikesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrushikesh.model.Product;
import com.hrushikesh.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	public Product getProduct(String productName) {
		return this.productRepo.findByProductNameContaining(productName);
	}
}

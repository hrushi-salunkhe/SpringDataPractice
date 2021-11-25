package com.hrushikesh.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {
	
	@Id
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;
	
	/*
	 * @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL) private
	 * List<Customer> customers;
	 */
	
}

package com.hrushikesh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_address")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "customer_id"
	)
	private List<Order> orders;
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "tbl_customer_product_mapping") private List<Product>
	 * products;
	 */
	
}

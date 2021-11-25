package com.hrushikesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
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
@Table(name="tbl_school")
public class School {
	@Id
//	@SequenceGenerator(name = "tbl_school_sequence", sequenceName = "tbl_school_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int id;
	
	@Column(name = "school_name")
	private String name;
	
	@Column(name = "school_address")
	private String address;
	
	@Column(name = "school_principal", nullable = false)
	private String prinicipal;
	
}

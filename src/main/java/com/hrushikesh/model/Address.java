package com.hrushikesh.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
	@AttributeOverride(column = @Column(name = "name"), name = "name"),
	@AttributeOverride(column = @Column(name = "state"), name = "state"),
	@AttributeOverride(column = @Column(name = "country"), name = "country"),
	@AttributeOverride(column = @Column(name = "zip_code"), name = "zipCode")
})
public class Address {
	private String city;
	private String state;
	private String country;
	private String zipCode;
}

package com.hrushikesh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentSchool {
	private String student_name;
	private Address student_address;
	private String school_name;
	private String school_address;
}

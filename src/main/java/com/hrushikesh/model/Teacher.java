package com.hrushikesh.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_teacher")
public class Teacher {
	@Id
	@Column(name = "staff_id")
	private Long staffId;
	
	@Column(name = "staff_name")
	private String name;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private Set<Course> courses;
}

package com.hrushikesh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="tbl_course")
public class Course {	
	@Id
	private long courseId;
	
	@Column(name = "course_title")
	private String courseTitle;

	@Column(name = "credit")
	private Integer credit;
	
	@OneToOne(
		mappedBy = "course"
	)
	private CourseMaterial material;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="staff_id")
	private Teacher teacher;
	
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private Set<Student> students;
}

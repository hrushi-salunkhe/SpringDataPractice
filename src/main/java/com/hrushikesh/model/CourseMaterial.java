package com.hrushikesh.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="tbl_course_material")
@ToString(exclude = "course")
public class CourseMaterial {
	
	@Id
	@Column(name = "course_material_id")
	private long courseMaterialId;

	private String url;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(
		name = "course_id",
		referencedColumnName = "courseId"
	)
	private Course course;
}

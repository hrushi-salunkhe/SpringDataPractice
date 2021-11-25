package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Course;
import com.hrushikesh.model.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	TeacherRepo repo;

	@Test
	void saveTeacher() {
		
		Course course1 = Course.builder().courseId(6).courseTitle("Maths").credit(500).build();
		Course course2 = Course.builder().courseId(7).courseTitle("Science").credit(600).build();
		Course course3 = Course.builder().courseId(8).courseTitle("Algebra").credit(400).build();
		
		Set<Course> courses = new HashSet<>();
		
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		Teacher teacher = Teacher.builder()
							.staffId(1L)
							.name("Sir")
							.courses(courses)
							.build();
		
		this.repo.save(teacher);
		
		System.out.println(this.repo.findAll());
		
	}

}

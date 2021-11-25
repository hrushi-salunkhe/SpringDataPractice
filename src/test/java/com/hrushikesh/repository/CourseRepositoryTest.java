package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Course;
import com.hrushikesh.model.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	
	@Autowired
	CourseRepo repo;

	@Test
	void test() {
		
		Teacher teacher = Teacher.builder()
				.staffId(1L)
				.name("Sir")
				.build();
		
		Course course1 = Course.builder().courseId(6).courseTitle("Maths").credit(500).teacher(teacher).build();
		Course course2 = Course.builder().courseId(7).courseTitle("Science").credit(600).teacher(teacher).build();
		Course course3 = Course.builder().courseId(8).courseTitle("Algebra").credit(400).teacher(teacher).build();
		
//		
		this.repo.save(course1);
		this.repo.save(course2);
		this.repo.save(course3);
		
		System.out.println(this.repo.findAll());
		
	}

}

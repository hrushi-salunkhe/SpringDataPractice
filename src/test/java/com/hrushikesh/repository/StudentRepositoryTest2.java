package com.hrushikesh.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Course;
import com.hrushikesh.model.Student;

@SpringBootTest
class StudentRepositoryTest2 {

	@Autowired
	StudentRepository repo;
	
	@Test
	void test() {
		Course course1 = Course.builder()
				  .courseId(221)
				  .courseTitle("DSA")
				  .credit(100)
				  .build();
		
		Course course2 = Course.builder()
				.courseId(222)
				.courseTitle("Graph")
				.credit(100)
				.build();
		
		Course course3 = Course.builder()
				.courseId(223)
				.courseTitle("AI")
				.credit(100)
				.build();
		
		Set<Course> set = new HashSet<>();
		
		set.add(course1);
		set.add(course2);
		set.add(course3);
		
		
		Student student = Student.builder()
				 .id(41)
				 .firstName("Hamelt")
				 .lastName("DD")
				 .email("jm@nfl.com")
				 .school_id("2")
				 .courses(set)
				 .build();		
		
		this.repo.save(student);
		
		set.clear();
		
		set.add(course1);
		set.add(course2);
		
		
		student = Student.builder()
				.id(42)
				.firstName("Genghis")
				.lastName("KKK")
				.email("jm@nfl.com")
				.school_id("2")
				.courses(set)
				.build();		
		this.repo.save(student);
		
		
		set.clear();
		
		set.add(course2);
		set.add(course3);
		
		
		student = Student.builder()
				.firstName("Kublai")
				.lastName("KKK")
				.email("jm@nfl.com")
				.school_id("2")
				.courses(set)
				.build();		
		this.repo.save(student);
		
		
		
		
	}

}

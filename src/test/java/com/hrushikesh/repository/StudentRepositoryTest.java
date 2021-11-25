package com.hrushikesh.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrushikesh.model.Address;
import com.hrushikesh.model.Course;
import com.hrushikesh.model.CourseMaterial;
import com.hrushikesh.model.School;
import com.hrushikesh.model.Student;
import com.hrushikesh.model.StudentSchool;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	SchoolRepo schoolRepo;
	
	@Test
	@Disabled
	void saveStudent() {
		
		Address address = Address.builder()
								 .city("LA")
								 .state("CA")
								 .country("US")
								 .zipCode("411027")
								 .build();
		
		Student student = Student.builder()
								 .firstName("Jordan")
								 .lastName("Pete")
								 .email("jm@nfl.com")
								 .address(address)
								 .school_id("2")
								 .build();
		this.studentRepo.save(student);

		student = Student.builder()
				.firstName("Jess")
				.lastName("Pete")
				.email("jm@nfl.com")
				.address(address)
				.school_id("3")
				.build();
		this.studentRepo.save(student);
		
		
	}
	
	@Test
	@Disabled
	void saveSchool() {
		School s1=  School.builder()
//						  .id(1)
						  .name("LA High")
						  .address("LA")
						  .prinicipal("XXX")
						  .build();
		
		School s2=  School.builder()
//							.id(2)
							.name("LA High")
							.address("LA")
							.prinicipal("XXX")
							.build();
		
		School s3=  School.builder()
//							.id(3)
							.name("LA High")
							.address("LA")
							.prinicipal("XXX")
							.build();
		
		this.schoolRepo.save(s1);
		this.schoolRepo.save(s2);
		this.schoolRepo.save(s3);
		
	}
	
	@Test
	@Disabled
	void lastNameContaining() {
		List<Student> students = this.studentRepo.findByLastNameContaining("mi");
		System.out.println(students);
	}
	
	@Test
	@Disabled
	void testSchoolStud() {
		
		System.out.println(this.studentRepo.getStudentSchoolDetails(1));
	}
	
	@Test
	@Transactional
	@Disabled
	void testUpdateStudentName() {
		this.studentRepo.updateStudentName("xxxxxxxx", 1);
	}
	
	
	@Test
//	@Disabled
	void courseMaterialSave(@Autowired CourseMaterialRepository repo, @Autowired CourseRepo courseRepo) {
		
		Course course = Course.builder()
							  .courseId(1)
							  .courseTitle("Lombok")
							  .credit(100)
							  .build();
//		courseRepo.save(course);
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
										.courseMaterialId(200)
										.url("http://" + course.getCourseTitle())
										.course(course)
										.build();
		repo.save(courseMaterial);
	}
	
	@Test
	void courseMaterialPrint(@Autowired CourseMaterialRepository repo) {
		System.out.println("Material: " + repo.findAll());
	}
	
	@Test
	void coursePrint(@Autowired CourseRepo repo) {
		System.out.println("Course: " + repo.findAll());
	}
}

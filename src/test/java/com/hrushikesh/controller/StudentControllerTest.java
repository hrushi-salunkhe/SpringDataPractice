package com.hrushikesh.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hrushikesh.model.School;
import com.hrushikesh.model.Student;
import com.hrushikesh.repository.StudentRepository;

@WebMvcTest(StudentController.class)
//@DataJpaTest
class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@MockBean
	@Autowired
	private StudentRepository repo;

	@BeforeEach
	void setUp() throws Exception {
		Student student = Student.builder()
				 .id(90)
				 .firstName("Jordan")
				 .lastName("Pete")
				 .email("jm@nfl.com")
				 .school_id("2")
				 .build();
		
//		Mockito.when(this.repo.findById(90))
//				.thenReturn(Optional.of(student));

	}

	@Test
	@DisplayName("Test: Get Student By Id")
	void test() {
		try {
			MvcResult result = this.mockMvc.perform(get("student/byId/90").accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andReturn();
			
			System.out.println(result.getAsyncResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

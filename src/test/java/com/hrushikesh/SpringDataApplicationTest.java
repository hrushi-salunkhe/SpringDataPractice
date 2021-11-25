package com.hrushikesh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.hrushikesh.repository.StudentRepository;

@TestConfiguration
class SpringDataApplicationTest {
	
	@Bean
	public StudentRepository getStudentRepo(StudentRepository repo) {
		return repo;
	}

}

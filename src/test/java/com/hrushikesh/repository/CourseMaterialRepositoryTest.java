package com.hrushikesh.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hrushikesh.model.CourseMaterial;

@DataJpaTest
class CourseMaterialRepositoryTest {

	@Autowired private CourseMaterialRepository repo;
	
	@Autowired private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		this.entityManager.persist(CourseMaterial.builder().courseMaterialId(199L).url("Angular").build());
		this.entityManager.persist(CourseMaterial.builder().courseMaterialId(192L).url("Spring").build());
		this.entityManager.persist(CourseMaterial.builder().courseMaterialId(193L).url("AWS").build());
	}

	@Test
	@DisplayName("Test: Get CourseMaterial by Id")
	void test() {
		Optional<CourseMaterial> courseMaterial = this.repo.findById(192L);
		
		assertThat(courseMaterial.get()).isNotNull();
	}

}

package com.hrushikesh.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrushikesh.model.Student;
import com.hrushikesh.model.StudentSchool;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameIn(List<String> firstName);
	
	List<Student> findByLastNameContaining(String keyword);
	
	@Query(
			value = "select new com.hrushikesh.model.StudentSchool(concat(st.firstName, ' ', st.lastName), st.address, sc.name, sc.address)"
					+ " from Student st, School sc"
					+ " where st.id = :student_id"
					+ " AND st.school_id = sc.id",
			nativeQuery = false
	)
	StudentSchool getStudentSchoolDetails(@Param("student_id") int student_id);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Modifying
	@Query(
		value = "update Student set firstName=:name where id=:student_id",
		nativeQuery = false
	)
	int updateStudentName(@Param("name") String name, @Param("student_id") int student_id);
}


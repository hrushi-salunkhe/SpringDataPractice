package com.hrushikesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrushikesh.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}

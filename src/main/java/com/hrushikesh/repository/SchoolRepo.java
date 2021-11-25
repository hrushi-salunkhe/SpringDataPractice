package com.hrushikesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrushikesh.model.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {

}

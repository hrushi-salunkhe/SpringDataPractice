package com.hrushikesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrushikesh.model.Student;
import com.hrushikesh.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/all")
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	@GetMapping("/byId/{student_id}")
	public Optional<Student> getAll(@PathVariable Integer student_id) {
		return studentRepo.findById(student_id);
	}
	
	@GetMapping("/all/sort/{sortField}")
	public List<Student> getAll(@PathVariable String sortField) {
		Sort sort = Sort.by(Sort.Direction.DESC, sortField);
		return studentRepo.findAll(sort);
	}
	
	@GetMapping("/all/{pageNo}/{pageSize}")
	public List<Student> getAll(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		
		Student student = Student.builder()
							     .email("akjndkjsnd")
							   .firstName("asvhjv")
							   .lastName("asdsad")
							   .build();
		
		System.out.println(student);
		
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		return studentRepo.findAll(page).getContent();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Student s) {
		this.studentRepo.save(s);
	}
	
	@PostMapping("/saveAll")
	public void save(@RequestBody List<Student> list) {
		this.studentRepo.saveAll(list);
	}
	
	@GetMapping("/{firstName}")
	public List<Student> firstName(@PathVariable String firstName) {
		return this.studentRepo.findByFirstName(firstName);
	}
	
	@PostMapping("/firstNameIn")
	public List<Student> firstNameIn(@RequestBody List<String> names) {
		return this.studentRepo.findByFirstNameIn(names);
	}
	
	@GetMapping("/{firstName}/{lastName}")
	public List<Student> firstName(@PathVariable String firstName, @PathVariable String lastName) {
		return this.studentRepo.findByFirstNameOrLastName(firstName, lastName);
	}
}

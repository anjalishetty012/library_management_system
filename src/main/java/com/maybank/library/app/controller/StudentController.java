package com.maybank.library.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.library.app.model.Student;
import com.maybank.library.app.service.inte.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
		
	}
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}

	
}

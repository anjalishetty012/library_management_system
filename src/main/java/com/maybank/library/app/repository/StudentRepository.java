package com.maybank.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.library.app.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	

}

package com.maybank.library.app.service.inte;

import java.util.List;

import com.maybank.library.app.model.Student;

public interface StudentService {
		Student saveStudent(Student student);
		List<Student> getAllStudents();

		
}

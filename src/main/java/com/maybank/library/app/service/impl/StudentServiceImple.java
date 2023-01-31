package com.maybank.library.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.maybank.library.app.model.Book;
import com.maybank.library.app.model.Student;
import com.maybank.library.app.repository.BookRepository;
import com.maybank.library.app.repository.StudentRepository;
import com.maybank.library.app.service.inte.StudentService;

@Service
public class StudentServiceImple implements StudentService{
	
	private StudentRepository studentRepository;
	
	
	
	
	
	
	public StudentServiceImple(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}





	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}





	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
		}





	





//	@Override
//	public Student assignStudent(Student student) {
//			Book book=bookRepository.findById(id).get();
//			
//			Student student1=studentRepository.findById(studentId).get();
//			book.assignStudent
//		}
//	}

}

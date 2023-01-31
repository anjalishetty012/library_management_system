package com.maybank.library.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		 private int studentId;
		@Column(name="student_name",nullable=false)
		 private String studentName;
		
		 
//		 @OneToOne(mappedBy="student")
//		 private Book book;
		
		
		@JsonIgnore
		@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
		private List<Book> books; 
		 
}

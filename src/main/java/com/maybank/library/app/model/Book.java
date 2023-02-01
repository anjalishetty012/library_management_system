package com.maybank.library.app.model;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Size(min=1, message="Book name can not be blank ")
	@Column(name="book_name", nullable=false)
	private String bookName;
	
	
//	@Column(name="author")
//	private String author;
//	
	@NotNull
	@Column(name="no_of_pages")
	private int noOfPages;
	
//	@Column(name="date")
//	LocalDate date;
	
	@Column(name="date_time")
	LocalDateTime dateTime;
	
//	@Column(name="time")
//	LocalTime time;
//	@OneToOne
//	@JoinColumn(name="student_id")
//	private Student student;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName="studentId")
	private Student student;
	
	@ManyToMany
	@JoinTable(name="books_authors",joinColumns=@JoinColumn(name="id"),
	inverseJoinColumns=@JoinColumn(name="authorId"))
	private List<Author> authors;
	
	
	

	
	

	//private List<Author> writtenBy;

	public void writtenBy(Author author) {
		authors.add(author);
		
	}




	
	
	
	
	

}


package com.maybank.library.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.library.app.model.Book;
import com.maybank.library.app.model.Student;
import com.maybank.library.app.repository.BookRepository;
import com.maybank.library.app.repository.StudentRepository;
import com.maybank.library.app.service.inte.BookService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/books")
public class BookController {
	private BookService bookService;
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	
	@PostMapping()
	public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAll")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long id){
		
		return new ResponseEntity<Book>(bookService.getBookById(id),HttpStatus.OK);
		
	}
	
	//update
	@PutMapping("{id}")
	public ResponseEntity<Book> updateBook( @PathVariable("id")long id,@RequestBody Book book){
		
		return new ResponseEntity<Book>(bookService.updateBook(book, id),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id")long id){
		bookService.deleteBook(id);
		
		return new  ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
		
		
	}
	
//	@GetMapping("/getBookByAuthor/{author}")
//	public List<Book> getBookByAuthor(@PathVariable String author){
//		return bookService.getBookByAuthor(author);
//	
//	}
	
	//To show to many-to-one mapping
	@PutMapping("/{id}/student/{studentId}")
	public Book assignStudentToBook(@PathVariable Long id,
			@PathVariable Integer studentId) {
	     return bookService.assignStudent(id,studentId );
	}
	
	// To show many-to-many mapping
	@PutMapping("/{id}/author/{authorId}")
	public Book assignAuthorToBooks(@PathVariable Long id,
			@PathVariable Long authorId) {
	     return bookService.assignAuthorToBooks(id,authorId );
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

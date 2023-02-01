package com.maybank.library.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.library.app.exception.ResourceNotFoundException;
import com.maybank.library.app.model.Author;
import com.maybank.library.app.model.Book;
import com.maybank.library.app.model.Student;
import com.maybank.library.app.repository.AuthorRepository;
import com.maybank.library.app.repository.BookRepository;
import com.maybank.library.app.repository.StudentRepository;
import com.maybank.library.app.service.inte.BookService;

@Service
public class BookServiceImple implements BookService{

private BookRepository bookRepository;

    @Autowired
	private StudentRepository studentRepository;
    
    @Autowired
    private AuthorRepository authorRepository;
	
	public BookServiceImple(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	


	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}




	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	
	
	
	
	@Override
	public Book getBookById(long id) {
		return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","Id",id));
	}




	@Override
	public Book updateBook(Book book, long id) {
		//check if book is present
		Book existingBook= bookRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Book","Id",id));
		
		existingBook.setBookName(book.getBookName());
		//existingBook.setAuthor(book.getAuthor());
		existingBook.setNoOfPages(book.getNoOfPages());
		
		bookRepository.save(existingBook);
		return existingBook;
	}




	@Override
	public void deleteBook(long id) {
		//check if book is present
		bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","Id",id));
		
		bookRepository.deleteById(id);
		
	}




//	@Override
//	public List<Book> getBookByAuthor(String author) {
//		//return bookRepository.getBookByAuthor(author);
//		return bookRepository.findByAuthor(author);
//	
//	}




	@Override
	public Book assignStudent(long id, int studentId) {
		Book book=bookRepository.findById(id).get();
		
		Student student=studentRepository.findById(studentId).get();
		book.setStudent(student);
	//	book.setDate(LocalDate.now());
	//	book.setTime(LocalTime.now());
		book.setDateTime(LocalDateTime.now());
		
		return bookRepository.save(book);
		
		
	}
	
	@Override
	public Book assignAuthorToBooks(long id, long authorId) {
		Book book=bookRepository.findById(id).get();
		
		Author author=authorRepository.findById(authorId).get();
		book.writtenBy(author);
		return bookRepository.save(book);
	}

		
}

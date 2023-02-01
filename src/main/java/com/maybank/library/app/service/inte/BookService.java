package com.maybank.library.app.service.inte;

import java.util.List;

import com.maybank.library.app.model.Author;
import com.maybank.library.app.model.Book;

public interface BookService {
	Book saveBook(Book book);

	List<Book> getAllBooks();
	
	Book getBookById(long id);
	
	Book updateBook(Book book,long id);
	
	void deleteBook(long id);
	
	//List<Book> getBookByAuthor(String author);
	
	Book assignStudent(long id,int studentId);
	
	Book assignAuthorToBooks(long id,long authorId);
	
	

}

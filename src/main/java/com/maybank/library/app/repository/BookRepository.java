package com.maybank.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maybank.library.app.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	

	
	//public List<Book> findByAuthor(String author);
	
		
}

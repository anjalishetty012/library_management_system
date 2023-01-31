package com.maybank.library.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maybank.library.app.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	

	
	public List<Book> findByAuthor(String author);
	
		
}

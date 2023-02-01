package com.maybank.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.library.app.model.Author;

public interface AuthorRepository  extends JpaRepository<Author,Long>{
	

}

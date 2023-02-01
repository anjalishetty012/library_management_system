package com.maybank.library.app.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.maybank.library.app.exception.ResourceNotFoundException;
import com.maybank.library.app.model.Author;
import com.maybank.library.app.repository.AuthorRepository;
import com.maybank.library.app.service.inte.AuthorService;

@Service
public class AuthorServiceImple implements AuthorService{
	
	private AuthorRepository authorRepository;
	
	

	public AuthorServiceImple(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}



	@Override
	public Author saveAuthor(Author author) {
		
		return authorRepository.save(author);
	 
		
	}

	
	//Implementation of optional class

	@Override
	public Optional<Author> getAuthorById(long authorId) {
		Optional<Author> optionalAuthor = Optional.ofNullable(authorRepository.findById(authorId).orElseThrow(()->
		new ResourceNotFoundException("Author","Id",authorId)));
		
		return optionalAuthor;
		
	}


	// Implementation of stream and map
	@Override
	public Stream<String> displayAllAuthors() {
		List<Author> allAuthors=authorRepository.findAll();
		
		Stream<String> allAuthorName=allAuthors.stream().map(a->a.getAuthor());
		
		
		return allAuthorName;
		
		
		
		
		
	}

	

}

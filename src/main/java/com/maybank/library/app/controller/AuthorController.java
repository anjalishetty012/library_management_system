package com.maybank.library.app.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.library.app.model.Author;
import com.maybank.library.app.service.inte.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	@PostMapping()
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
		return new ResponseEntity<Author>(authorService.saveAuthor(author),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getAuthorById/{authorId}")
	public ResponseEntity<Optional<Author>> getBookById(@PathVariable("authorId") long authorId){
		
		return new ResponseEntity<Optional<Author>>(authorService.getAuthorById(authorId),HttpStatus.OK);
		
	} 
	
	@GetMapping("getAuthorNames")
	public Stream<String> displayAuthors(){
		return authorService.displayAllAuthors();
	}

}

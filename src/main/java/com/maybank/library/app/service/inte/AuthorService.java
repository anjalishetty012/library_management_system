package com.maybank.library.app.service.inte;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.maybank.library.app.model.Author;

public interface AuthorService {

	Author saveAuthor(Author author);
	
	Optional<Author> getAuthorById(long authorId);
	
	Stream<String> displayAllAuthors();
		
}

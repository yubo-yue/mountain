package com.mountain.repository;

import java.util.List;

import com.mountain.domain.Book;
import com.mountain.domain.BookSearchCriteria;
import com.mountain.domain.Category;

public interface BookRepository {
	
	Book findById(long id);
	
	List<Book> findByCategory(final Category category);
	
	List<Book> findRandom(int count);
	
	List<Book> findBooks(final BookSearchCriteria bookSearchCriteria);
	
	void storeBook(final Book book);
}

package com.example.book.management.service;

import java.util.List;

import com.example.book.management.entity.BookEntity;

public interface BookService {

	List<BookEntity> getAllBooks();
	
	BookEntity getBookById(Long id);
	
	String saveBook(BookEntity book);
	
	String updateBook(BookEntity book, Long id);
	
	void deleteBookbyId(Long id);	
}

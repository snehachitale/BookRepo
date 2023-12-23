package com.example.book.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.management.entity.BookEntity;
import com.example.book.management.exceptions.BookAlreadyExistsException;
import com.example.book.management.exceptions.ErrorResponse;
import com.example.book.management.service.BookService;

@RestController
@RequestMapping("/book")
@Component
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<BookEntity> getAllBooks() {
		List<BookEntity> books = bookService.getAllBooks();
		System.out.println("Books: "+books);
		return books;
	}
	
	@GetMapping("/{id}")
	public BookEntity getBookById(@PathVariable Long id) {
		BookEntity book = bookService.getBookById(id);
		System.out.println("Book Id: " +id+ " : Book : " +book);
		return book;
	}
	
	@PostMapping
	public String saveBook(@RequestBody BookEntity book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping
	public String updateBook(@RequestBody BookEntity book, @PathVariable Long id) {
		return bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBookById(@PathVariable Long id) {
		bookService.deleteBookbyId(id);
		return "Book deleted successfully";
	}
	
	@ExceptionHandler(value
            = BookAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse
	handleBookAlreadyExistsException(
			BookAlreadyExistsException ex)
	{
	return new ErrorResponse(HttpStatus.CONFLICT.value(),
	                       ex.getMessage());
	}
}

package com.example.book.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.example.book.management.entity.BookEntity;
import com.example.book.management.exceptions.BookAlreadyExistsException;
import com.example.book.management.exceptions.BookNotFoundException;
import com.example.book.management.repository.BookRepository;
import com.example.book.management.service.BookService;

@Service
@CacheConfig(cacheNames={"book"})   
public class BookServiceImplementation implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookEntity> getAllBooks() {
		return (List<BookEntity>) bookRepository.findAll();
	}
	
	public BookEntity getBookById(Long id) {
		return bookRepository.findById(id).orElseThrow(
	            ()
	                -> new BookNotFoundException(
	                    "NO BOOK PRESENT WITH ID = " + id));
	}

	@Override
	public String saveBook(BookEntity book) {
		BookEntity existingBook
        = bookRepository.findById(book.getId())
              .orElse(null);
    if (existingBook == null) {
        bookRepository.save(book);
        return "Book added successfully";
    }
    else
        throw new BookAlreadyExistsException(
            "Book already exists!!");
	}

	@Override
	public String updateBook(BookEntity book, Long id)  {
		BookEntity existingBook
        = bookRepository.findById(book.getId())
              .orElse(null);
    if (existingBook == null)
        throw new BookNotFoundException(
            "No Such Book exists!!");
    else {
    	existingBook.setTitle(book.getTitle());
    	existingBook.setAuthor(book.getAuthor());
    	existingBook.setPublishedDate(book.getPublishedDate());
    	existingBook.setGenre(book.getGenre());
        bookRepository.save(existingBook);
        return "Record updated Successfully";
    }
	}

	@Override
	public void deleteBookbyId(Long id) {
		bookRepository.deleteById(id);
	}
}

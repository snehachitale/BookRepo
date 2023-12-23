package com.example.book.management;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.book.management.entity.BookEntity;
import com.example.book.management.repository.BookRepository;

@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void saveBookTest() {
		BookEntity book = new BookEntity();
		book.setTitle("Book Test");
		book.setAuthor("Author Test");
		book.setIsbn(950482040L);
		book.setPublishedDate(Date.from(Instant.now()));
		book.setGenre("Suspense");
		
		bookRepository.save(book);
		
		assertThat(book.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getBookTest() {
		BookEntity book = bookRepository.findById(1L).get();
		
		assertThat(book.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getListOfBookTest() {
		List<BookEntity> books = (List<BookEntity>) bookRepository.findAll();
		
		assertThat(books.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateBookTest() {
		BookEntity book = bookRepository.findById(1L).get();
		book.setAuthor("Author Test1");
		BookEntity bookUpdated = bookRepository.save(book);
		assertThat(bookUpdated.getAuthor()).isEqualTo("Author Test1");
	}
	
	@Test
	public void deleteBookTest() {
		BookEntity book = bookRepository.findById(1L).get();
	     
	    bookRepository.deleteById(book.getId());
	     
	    BookEntity deleteBook = bookRepository.findById(1L).get();
	     
	    assertThat(deleteBook).isNull();       
	}
}

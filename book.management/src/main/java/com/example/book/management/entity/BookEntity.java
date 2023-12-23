package com.example.book.management.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Entity
@Table(name = "BookTable")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "isbn")
	private Long isbn;
	
	@Column(name = "publishedDate")
	private Date publishedDate;
	
	@Column(name = "genre")
	private String genre;
	
	public BookEntity() {
		
	}

	public BookEntity(Long id, String title, String author, Long isbn, Date publishedDate, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishedDate = publishedDate;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}

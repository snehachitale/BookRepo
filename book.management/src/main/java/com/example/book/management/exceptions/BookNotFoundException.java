package com.example.book.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
    public BookNotFoundException() {}
    
    public BookNotFoundException(String msg){
    	super(msg);
        this.message = msg;
    }
}
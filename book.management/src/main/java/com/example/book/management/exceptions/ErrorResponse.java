//Custom Error Response Class

package com.example.book.management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

 private int statusCode;
 private String message;

 public ErrorResponse(int i, String message)
 {
     super();
     this.message = message;
 }

//public ErrorResponse(int value, String message2) {
//	super();
//	this.statusCode = value;
//	this.message = message2;
//}
}

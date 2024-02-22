package com.springtraining.demos.springboot1.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springtraining.demos.springboot1.entities.ErrorMessage;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> bookNotFoundEx(BookNotFoundException ex, WebRequest request){
		ErrorMessage msg = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		
	}
	
	@ExceptionHandler(BadRequestException1.class)
	public ResponseEntity<ErrorMessages> invalidBookObject(BadRequestException1 ex,WebRequest request){
		ErrorMessages msg = new ErrorMessages(HttpStatus.BAD_REQUEST,ex.getMessages());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
		
		
	}
	
}

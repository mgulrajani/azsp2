package com.springtraining.demos.springboot1.exceptions;

public class BookNotFoundException extends Exception {
private String message;

	public String getMessage() {
	return message;
}



public void setMessage(String message) {
	this.message = message;
}



	public BookNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BookNotFoundException(String message) {
		super(message);
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	
	
}

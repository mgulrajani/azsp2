package com.springtraining.demos.springboot1.exceptions;

import java.util.ArrayList;
import java.util.List;

public class BadRequestException1 extends Exception{

	private List<String> messages =new ArrayList<>();

	public BadRequestException1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BadRequestException1(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException1(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException1(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException1(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException1(List<String> list1) {
		this.messages  = list1;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	

}

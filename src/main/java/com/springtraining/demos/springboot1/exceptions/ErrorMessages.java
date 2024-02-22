package com.springtraining.demos.springboot1.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessages {
	
	private  HttpStatus status;
	private List<String> messages;
	
}

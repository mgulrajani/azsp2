package com.springtraining.demos.springboot1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.exceptions.BadRequestException1;
import com.springtraining.demos.springboot1.exceptions.BookNotFoundException;
import com.springtraining.demos.springboot1.services.IBookService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {
	
	List<String> list1 = new ArrayList<>();
	
	ValidatorFactory factory =  Validation.buildDefaultValidatorFactory();
	
	Validator validator=factory.getValidator();
	Set<ConstraintViolation<Book>> violations=null;
	
			
	
	
	// i want to create an API which will  be exposed for allowing to add a book to the colleciton of books
	
	//my controller will use service
	@Autowired
	private IBookService service;
	@PostMapping
	public ResponseEntity<Object> addBook(@Valid @RequestBody Book book) throws BadRequestException1 {
		
		violations = validator.validate(book);
		if(!violations.isEmpty()) {
		for(ConstraintViolation<Book> violation:violations) {
			//System.out.println(violation.getMessage());
			list1.add(violation.getMessage());
			System.out.println(list1);}
		    throw new BadRequestException1(list1);		
		
		}
		else {
		service.addBook(book);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(book)	;
		}
		
		
		
	}
	@GetMapping
	public List<Book>getAllBook() {
		return service.getAllBooks();
		
		
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) throws BookNotFoundException {
		
		return service.findById(id);
			
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable int  id,@Valid @RequestBody Book book) throws BadRequestException1 {
		
		/*
		 * violations = validator.validate(book); if(!violations.isEmpty()) {
		 * for(ConstraintViolation<Book> violation:violations) {
		 * //System.out.println(violation.getMessage());
		 * list1.add(violation.getMessage()); System.out.println(list1);} throw new
		 * BadRequestException1(list1);
		 * 
		 * } else {
		 */
		
		
		try {
			service.updateBook(id, book);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return book;
		}
		
		
		
	
	
	@GetMapping("/title/{title}")
	public Book getBookByTitle(@PathVariable String title)  {
		
		return service.findByTitle(title);
		
			
	}
	
	@DeleteMapping("{id}")
	public Book deleteById(@PathVariable int id)  {
		
		return service.deleteById(id);
		
			
	}
	
}



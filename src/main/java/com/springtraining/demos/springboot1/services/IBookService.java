package com.springtraining.demos.springboot1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.exceptions.BookNotFoundException;

@Service
public interface IBookService {
	
	public Book addBook(Book b1);
	
	public List<Book> getAllBooks();
	
	public Book findById(int id) throws BookNotFoundException;
	
	public Book findByTitle(String title);
	
	public Book updateBook(int id , Book b) throws BookNotFoundException ;
	
	public Book deleteById(int id) ;
	
}
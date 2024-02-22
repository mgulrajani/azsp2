package com.springtraining.demos.springboot1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.demos.springboot1.entities.Book;

@Repository
public interface IBookRepository  extends JpaRepository<Book, Integer>{
	
	public Book findByTitle(String title);
	
}

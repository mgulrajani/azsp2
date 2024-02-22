package com.springtraining.demos.springboot1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.repo.IBookRepository;

import static org.junit.jupiter.api.Assertions.*;
//this is just testing in isolation
//what are we testing  Repository layer

@DataJpaTest
public class BookRepoTest {

	@Autowired
	private IBookRepository repo;
	
	 @Autowired
	 private TestEntityManager em;
	 
	 Book book;
	 
	 @BeforeEach
	 void setUp() {
		 book=new Book("Sapiens",1700);
		
		 em.persist(book);
		 
		  
	 }
		/*
		 * @Disabled
		 * 
		 * @Test public void whenFindById_ThenGetBook() { //here i am getting back the
		 * book which is persisted by em //we are the repo layer Book
		 * b=repo.findById(book.getId()).get();
		 * 
		 * 
		 * assertEquals("Sapiens",b.getTitle());
		 * 
		 * }
		 */

}

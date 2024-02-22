package com.springtraining.demos.springboot1;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.exceptions.BookNotFoundException;
import com.springtraining.demos.springboot1.repo.IBookRepository;
import com.springtraining.demos.springboot1.services.BookService;

import static org.junit.jupiter.api.Assertions.*;
/***
 * 
 * Spring framework introduction
 * annotation based configuration @Configuration @Bean , stereotype annotation COmponent Service 
   xml metadata 
 *  Spring AOP
 *  Spring Boot -Data JpA
 *  Spring Boot -Rest 
 *  Logging features
 *  Exception handling in Spring BOOt
 *  test - controller ,service ,datajpa 
 *   Microservices - spring boot - 
 *   how we can register them with eureka server , they could be discovered 
 *   with just their names
 *   not hardcoded to hostname or port numbers
 *   we could reach CITIZEN-SERVICE
 *   
 *   fallback  -- resilience  ,fault tolerance
 *   if one service is down ,at least the service that is up should send the data
 *   
 *   API gateway -- 10 services - 8082 8083 8084 ...8090
 *   create a gateway which predicates  users/**  USER-SERVICE
 *   
 */

@SpringBootTest
public class BookServiceTest {
  
	//AAA -- 1.Arrange the facts (we are doing in beforeeach ,set up)  
	//,2. Act --means actually calling the method to be tested
	//3Assert  -- asserts to assert the values are they matching the expected
	
	@Autowired
	BookService service;

	@MockBean
	IBookRepository repo;
	
	Book b;
	
	@BeforeEach
	void setUp() {
		//Arrange
		
		 b=new Book(1,"Homo deus",LocalDate.now(),455);
		
		//using Mockito we are training the mock when repo.findById b
		
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(b));
        
        //why we are mocking
        //we are doing unit testing ,a single unit -which unit service is getting tested 
        
        
	}
	
	
	@Test
	public void testFindById() throws BookNotFoundException {
		
		//Act
		
		//testing the service layer method , by executing service.findById
		
		Book b = service.findById(1);
		
		
		
		//Assert
		assertEquals("Homo deus",b.getTitle());
		
	}

     @Test
     public void testAddBook() {
    	 //we are mocking the save method
    	 //here we are testing service layer
    	 //1.Arrange 
    	 Mockito.when(repo.save(b)).thenReturn(b);
    	 //2Act
    	 
    	 Book  bookAdded = service.addBook(b);
    	 //Assert 
    	 assertEquals(455,bookAdded.getPrice());
    	 
    	 
     }
	
	
}

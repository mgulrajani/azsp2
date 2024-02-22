package com.springtraining.demos.springboot1.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//this whole class will encapsulate the Logging concern of this app  

import com.springtraining.demos.springboot1.entities.Book;
@Component
@Aspect
public class BookLoggingAspect {
	//any method which we create in an Aspect is an advice
	//advices are of 5 types
	
	//JoinPoint is the encapsulated object which  is the method itself which is advised
	
	//PointCut is the expression that which methods are to be advised
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	
	@Before(value="(execution(* com.springtraining.demos.springboot1.controller.BookController.addBook(..)))")
	public void adviceBeforeAddBook(JoinPoint jp) {
		
		System.out.println("Started addBook "+jp.getSignature()+" "+LocalDateTime.now());
		
	}

	@After(value="(execution(* com.springtraining.demos.springboot1.controller.BookController.addBook(..)))")
	public void adviceAfterAddBook(JoinPoint jp) {
		
		System.out.println("Ended addBook "+jp.getSignature()+" "+LocalDateTime.now());
		
	}
	@Before(value="(execution(* com.springtraining.demos.springboot1.services.BookService.addBook(..)))")
	public void adviceBeforeAddBookService(JoinPoint jp) {
		
		System.out.println("Before  addBookservice "+jp.getSignature()+" "+LocalDateTime.now());
		
	}

	@After(value="(execution(* com.springtraining.demos.springboot1.services.BookService.addBook(..)))")
	public void adviceAfterAddBookService(JoinPoint jp) {
		
		System.out.println("After addBook service"+jp.getSignature()+" "+LocalDateTime.now());
		
	}
	@AfterReturning(value="(execution(* com.springtraining.demos.springboot1.services.BookService.findById(..)))",returning = "book")
	public void afterReturningFindById(JoinPoint jp, Book book) {
		
		log.info("Returning the book "+book);
	}
	

	@AfterThrowing(value="(execution(* com.springtraining.demos.springboot1.services.BookService.findById(..)))",throwing = "e")
	public void afterThrowingFindById(JoinPoint jp, Exception e) {
		log.error("Fetch failed"+e);
		
	}

	
	/*
	 * @Around(
	 * value="(execution(* com.springtraining.demos.springboot1.services.BookService.findById(..)))"
	 * ) public void aroundFetchById(ProceedingJoinPoint jp) throws Throwable {
	 * 
	 * log.info("called fetch by id"); jp.proceed(); log.info("after fetch"); }
	 */
	
}

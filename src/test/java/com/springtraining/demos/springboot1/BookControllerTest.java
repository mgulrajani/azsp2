package com.springtraining.demos.springboot1;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springtraining.demos.springboot1.controller.BookController;
import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.services.BookService;
@WebMvcTest(BookController.class)
class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService service;
	
	private Book book;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("some tasks which needs to be performed before all the tests , only once since it is at a class level");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	
		System.out.println("some tasks which needs to be performed after all the tests , only once since it is at a class level");
		
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("before every test");
		
		book=new Book(1,"Theory of Everything",LocalDate.now(),340);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		System.out.println("write the instructions to be performed after each test");
		
	}
  
	/*
	 * @Disabled
	 * 
	 * @Test void testAddBook() {
	 * Mockito.when(service.addBook(book)).thenReturn(book);
	 * 
	 * try { mockMvc. perform(MockMvcRequestBuilders .post("/books")
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content("{"+"\"title\""+":"+"\"Theory of Everything\","+"\"price\""+":"+340+
	 * "}")) .andExpect(MockMvcResultMatchers.status().isCreated()); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	
}

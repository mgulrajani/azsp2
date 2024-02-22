package com.springtraining.demos.springboot1.entities;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

//spring context will create a bean of any class which is annotated as a Component 
//inspecific if you know the purpose is repo , service or a controller 
@Component
@Entity
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message="Title is mandatory")
	
	private String title;
	
	private LocalDate dateOfPublishing;
	@Min(value=100,message="Enter min val of 100")
	@Max(value=2000,message="Enter max val of 2000")
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDateOfPublishing() {
		return dateOfPublishing;
	}
	public void setDateOfPublishing(LocalDate dateOfPublishing) {
		this.dateOfPublishing = dateOfPublishing;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", dateOfPublishing=" + dateOfPublishing + ", price=" + price
				+ "]";
	}
	public Book(int id, String title, LocalDate dateOfPublishing, double price) {
		super();
		this.id = id;
		this.title = title;
		this.dateOfPublishing = dateOfPublishing;
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, LocalDate dateOfPublishing, double price) {
		super();
		this.title = title;
		this.dateOfPublishing = dateOfPublishing;
		this.price = price;
	}
	public Book(String title, double price) {
		super();
		this.title = title;
		this.dateOfPublishing=LocalDate.now();
		this.price = price;
	}
	
	

}

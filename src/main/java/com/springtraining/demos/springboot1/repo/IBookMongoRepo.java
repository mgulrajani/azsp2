package com.springtraining.demos.springboot1.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.demos.springboot1.entities.Book;
@Repository
public interface IBookMongoRepo extends MongoRepository<Book,Integer>{

	Book findByTitle(String title);
	

}

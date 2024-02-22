package com.springtraining.demos.springboot1.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.demos.springboot1.entities.Book;
import com.springtraining.demos.springboot1.exceptions.BookNotFoundException;
import com.springtraining.demos.springboot1.repo.IBookRepository;

@Service
public class BookService implements IBookService {

	//service layer works with repo layer
	
	@Autowired
	private IBookRepository repo;
	
	@Override
	public Book addBook(Book book) {
		//book.setDateOfPublishing(LocalDate.now());
		// TODO Auto-generated method stub
		if (book.getDateOfPublishing() == null ) 
			book.setDateOfPublishing(LocalDate.now());
		return repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Book findById(int id) throws BookNotFoundException {

		Optional<Book> book = repo.findById(id);
		if(!book.isPresent()) {
			
			throw new BookNotFoundException("Book not found with this id");
			
		}
		return book.get();
		
		
	}

	@Override
	public Book findByTitle(String title) {
		// TODO Auto-generated method stub
		return repo.findByTitle(title);
	}

	@Override
	public Book updateBook(int id, Book b) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Book b1 = repo.findById(id).get();
		System.out.println(b1+"*****************");
		if(Objects.nonNull(b.getTitle()) && !"".equalsIgnoreCase(b.getTitle())){
			
				b1.setTitle(b.getTitle());
		}
		
		b1.setDateOfPublishing(b.getDateOfPublishing());
		b1.setPrice(b.getPrice());
		repo.save(b1);
		return b1;
	
	}

	@Override
	public Book deleteById(int id) {
		// TODO Auto-generated method stub
     Book b2=null;
	try {
		b2 = findById(id);
	} catch (BookNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 repo.deleteById(id);
	 return b2;
	}
	
	

}

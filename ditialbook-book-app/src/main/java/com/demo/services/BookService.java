package com.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public Book createBook(Book m) {
		m.setPublishDate(LocalDateTime.now());
		return repo.save(m);
	}
	
	
	public Book buyBook(int m) {
		//m.setPublishDate(LocalDateTime.now());
		return repo.findBookById(m);
	}

	public List<Book> findByCategory(String s) {
		// TODO Auto-generated method stub
		return repo.findByCategory(s);
	}
	public List<Book> findByAuthor(String s) {
		// TODO Auto-generated method stub
		return repo.findByAuthor(s);
	}
	public List<Book> findByAuthor1(String s) {
		// TODO Auto-generated method stub
		return repo.findByAuthor1(s);
	}
	public List<Book> findByPublisher(String s) {
		// TODO Auto-generated method stub
		return repo.findByPublisher(s);
	}
	public List<Book> findByPrice(int s) {
		// TODO Auto-generated method stub
		return repo.findByPrice(s);
	}
	
	


	
	
	
}

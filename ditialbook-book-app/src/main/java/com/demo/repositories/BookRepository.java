package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query("select b from Book b WHERE b.category = ?1 and b.block = 'No' ")
	public List<Book> findByCategory(String s);
	
	@Query("select b from Book b WHERE b.author = ?1 and b.block = 'No' ")
	public List<Book> findByAuthor(String s);
	
	@Query("select b from Book b WHERE b.author = ?1 ")
	public List<Book> findByAuthor1(String s);
	
	@Query("select b from Book b WHERE b.publisher = ?1 and b.block = 'No' ")
	public List<Book> findByPublisher(String s);
	
	@Query("select b from Book b WHERE b.price <= ?1 and b.block = 'No' ")
	public List<Book> findByPrice(int s);
	
	@Query("select b from Book b WHERE b.id = ?1  and b.block = 'No' ")
	public Book findBookById(int s);
	
	@Query("select b from Book b WHERE b.id = ?1  ")
	public Book findBookById1(int s);
	
	@Query("select b from Book b WHERE  b.block = 'No' ")
	public List<Book> findAll1();

	

	

	
}

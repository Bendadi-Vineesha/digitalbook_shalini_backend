package com.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;
import com.demo.services.BookService;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "https://hoppscotch.io/"})
@RequestMapping("/book/api/v1")
public class BookController {
	
//	@Autowired
//	private KafkaTemplate<String, Book> kafkaTemplate;
//
//	private static final String TOPIC = "kafka-topic";
//	private static final String TOPIC1 = "book-topic";

	
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("")
	public String bookPage()
	{return "Hi I am Book"; }
	

	
	
	@PostMapping("/createBook")
	//@KafkaListener(topics = "kafka-topic", groupId="group_id", containerFactory = "userKafkaListenerFactory")
 	public Book saveNewBook(@RequestBody Book m){ 
		m.setPublishDate(LocalDateTime.now());
		System.out.println(m);
		return bookService.createBook(m);
	
	} 
	
	
	

	
	@PutMapping("/updateBook")
	//@KafkaListener(topics = "book-topic", groupId="group_id", containerFactory = "userKafkaListenerFactory")
	public Book update(@RequestBody Book m){ 
		
		Book b= repo.findBookById1(m.getId());
		System.out.println(b.toString());
		if(b.getAuthor().equals(m.getAuthor())) {
			m.setPublishDate(LocalDateTime.now());
		return repo.save(m);}
		return null;
		
		

} 
	

	
	
	@GetMapping("/buyBook")
 	public Book buyBook(@RequestParam int id){
		//System.out.println(m);
		return bookService.buyBook(id);
	}
	
	@GetMapping("/findBookByCategory")
 	public List<Book> findBookByCategory(@RequestParam String category){
		
		//return s;
		return bookService.findByCategory(category);
	}
	@GetMapping("/findBookByAuthor")
 	public List<Book> findBookByAuthor(@RequestParam String author){
		
		//return s;
		return bookService.findByAuthor(author);
	}
	
	@GetMapping("/findBookByAuthor1")
 	public List<Book> findBookByAuthor1(@RequestParam String author){
		
		//return s;
		return bookService.findByAuthor1(author);
	}
	
	@GetMapping("/findBookByPublisher")
 	public List<Book> findBookByPublisher(@RequestParam String publisher){
		
		//return s;
		return bookService.findByPublisher(publisher);
	}
	
	@GetMapping("/findBookByPrice")
 	public List<Book> findBookByPrice(@RequestParam int price){
		
		//return s;
		return bookService.findByPrice(price);
	}
	
	@GetMapping("/subscribeBook")
 	public Book subscribeBook(@RequestParam int id){
		//System.out.println(m);
		return bookService.buyBook(id);
	}
	
	@GetMapping("/subscribedBook")
 	public Book subscribedBook(@RequestParam int id){
		//System.out.println(m);
		return bookService.buyBook(id);
	}
	
	@GetMapping("/subscribedBookById")
 	public Book subscribedBookById(@RequestParam int id){
		//System.out.println(m);
		return repo.findBookById1(id);
	}
	
	@GetMapping("/findAll")
 	public List<Book> findAll(){
		//System.out.println(m);
		return repo.findAll1();
	}
	
	@GetMapping("/findBookById")
 	public Book findBookById(@RequestParam int id){
		//System.out.println(m);
		return repo.findBookById(id);
	}
	
	@GetMapping("/findBookById1")
 	public Book findBookById1(@RequestParam int id){
		//System.out.println(m);
		return repo.findBookById1(id);
	}
	
	@DeleteMapping("/delete")
	public void deleteBook()
	{
		 repo.deleteAll();
	}
	
}

package com.demo.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.clients.BookClient;
import com.demo.entities.Book;
import com.demo.entities.Reader;
import com.demo.entities.Subscription;
import com.demo.entities.Subscription1;
import com.demo.repositories.ReaderRepository;
import com.demo.repositories.SubdcriberRepo1;
import com.demo.repositories.SubscriberRepo;
import com.demo.services.ReaderService;


@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "https://hoppscotch.io/"})
@RequestMapping("/reader/api/v1")
public class ReaderController {
	
	@Autowired
	private ReaderRepository repo;
	
	@Autowired
	private SubscriberRepo subRepo;
	
	@Autowired
	private SubdcriberRepo1 subRepo1;
	
	
	@Autowired
	private BookClient bookClient;
	
	@Autowired
	private ReaderService readerService;
	
//	@Autowired
//	private Reader r;
	
	//public Reader r = new Reader();
	//public static int pay = 10000;
	
	@GetMapping("")
 	public String test(){
		
		//return s;
		return "testing";
	}
	@GetMapping("/findAll")
 	public List<Book> findAll(){
		
		//return s;
		return bookClient.findAll();
	}

	@GetMapping("/getBookByCategory/{category}")
 	public List<Book> getBookByCategory(@PathVariable(value = "category") String category){
		
		//return s;
		return bookClient.getBookByCategory(category);
	}
	@GetMapping("/getBookByAuthor/{author}")
 	public List<Book> getBookByAuthor(@PathVariable(value = "author") String author){
		
		//return s;
		return bookClient.getBookByAuthor(author);
	}
	
	@GetMapping("/getBookByPublisher/{publisher}")
 	public List<Book> getBookByPublisher(@PathVariable(value = "publisher") String publisher){
		
		//return s;
		return bookClient.getBookByPublisher(publisher);
	}
	
	@GetMapping("/getBookByPrice/{price}")
 	public List<Book> getBookByPrice(@PathVariable(value = "price") int price){
		
		//return s;
		return bookClient.getBookByPrice(price);
	}
	@GetMapping("/getPurchasedBookByEmail/{readerEmail}")
 	public List<Reader> getPurchasedBookByEmail(@PathVariable(value = "readerEmail")String readerEmail){
		
		//return s;
		return readerService.getPurchasedBookByEmail(readerEmail);
	}
	
	@GetMapping("/getPurchasedBookByBookIdAndEmail/{id}/{readerEmail}")
 	public List<Reader> getPurchasedBookByBookIdAndEmail(@PathVariable(value = "id") int id , @PathVariable(value = "readerEmail") String readerEmail){
		
		//return s;
		return readerService.getPurchasedBookByBookIdAndEmail(id , readerEmail);
	}
	
	@GetMapping("/getPurchasedBookByBookPayIdAndEmail/{payId}/{readerEmail}")
 	public Reader getPurchasedBookByPayIdAndEmail(@PathVariable(value = "payId") int payId , @PathVariable(value = "readerEmail") String readerEmail){
		
		//return s;
		return readerService.getPurchasedBookByPayIdAndEmail(payId , readerEmail);
	}
	
	
	@PostMapping("/buy/{readerName}/{readerEmail}/{id}")
 	public String buyBook(@PathVariable (value = "readerName") String readerName,@PathVariable (value = "readerEmail") String readerEmail, @PathVariable (value = "id") int id){
		
		//System.out.println(reader);
		Reader r = new Reader();
		
		r.setReaderName(readerName);
		r.setReaderEmail(readerEmail);
	Book book= bookClient.buyBook(id);
	if(book == null)
		return " Book is not available" ;
	System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		System.out.println(book);
		r.setId(book.getId());
		r.setTitle(book.getTitle());
	r.setAuthor(book.getAuthor());
	r.setBlock(book.getBlock());
	r.setCategory(book.getCategory());
	r.setContent(book.getContent());
	r.setPublisher(book.getPublisher());
	r.setPrice(book.getPrice());
	r.setPayTime(LocalDateTime.now());
	//System.out.println(r);
	//r.setPayId(pay++);
	
	System.out.println(r);
		Reader r1=  readerService.saveBook(r);
		return "Book Purchased, payment id :" + r1.getPayId() ;
	}
	
	
	
	@GetMapping("/subscribe/{subscriberName}/{subscriberEmail}/{book_id}")
	public Subscription subscribe(@PathVariable (value = "subscriberName") String subscriberName,@PathVariable (value = "subscriberEmail") String subscriberEmail, @PathVariable (value = "book_id") int book_id) {
Subscription sub = new Subscription();
		
		sub.setSubscriberName(subscriberName);
		sub.setSubscriberEmail(subscriberEmail);
	Book book= bookClient.subscribeBook(book_id);
	if(book!=null)
	{
		sub.setBook_id(book_id);
		subRepo.save(sub);
		return sub;
	}
		return null;
		
		//return "Book is not subscribed reason can be book not available or you are entering invalid book_id " ;
	}
	
	
	@GetMapping("/subscribe1/{subscriberName}/{subscriberEmail}/{book_id}")
	public Subscription1 subscribe1(@PathVariable (value = "subscriberName") String subscriberName,@PathVariable (value = "subscriberEmail") String subscriberEmail, @PathVariable (value = "book_id") int book_id) {
Subscription1 sub = new Subscription1();
Subscription1 sub2 = subRepo1.findByBookIdandReaderEmail(book_id, subscriberEmail);

if(sub2!=null)
{
	return null;
}
else {
		
		sub.setReaderName(subscriberName);
		sub.setReaderEmail(subscriberEmail);
		sub.setPayTime(LocalDateTime.now());
	Book book= bookClient.subscribeBook(book_id);
	if(book!=null)
	{
		sub.setBook_id(book_id);
		subRepo1.save(sub);
		return sub;
	}
		return null;
		
		//return "Book is not subscribed reason can be book not available or you are entering invalid book_id " ;
	}
	}
	
	@GetMapping("/subscribedBook/{subscriberEmail}")
	public List<Book> subscribedBook(@PathVariable (value = "subscriberEmail") String subscriberEmail)
	{
		
		List<Book> bookList = new ArrayList<>();
	
		List<Subscription> list = subRepo.findBySubscriberEmail(subscriberEmail);
		
		for(Subscription sub : list)
		{
			Book book= bookClient.subscribedBook(sub.getBook_id());
			bookList.add(book);
		}
		if(bookList!=null)
		return bookList;
		else
			return null;
	}
	
	@GetMapping("/subscribedBook1/{subscriberEmail}")
	public List<Book> subscribedBook1(@PathVariable (value = "subscriberEmail") String subscriberEmail)
	{
		
		List<Book> bookList = new ArrayList<>();
		List<Subscription1> list = subRepo1.findBySubscriberEmail(subscriberEmail);
		
		for(Subscription1 sub : list)
		{
			Book book= bookClient.subscribedBookById(sub.getBook_id());
			bookList.add(book);
		}
		if(bookList!=null)
		return bookList;
		else
			return null;
	}
	
	@GetMapping("/subscribedBooksDetail/{subscriberEmail}")
	public List<Subscription1> subscribedBookdetails(@PathVariable (value = "subscriberEmail") String subscriberEmail)
	{
		
		List<Book> bookList = new ArrayList<>();
		List<Subscription1> list = subRepo1.findBySubscriberEmail(subscriberEmail);
		if(list!=null)
		return list;
		else
			return null;
	}
	
	@DeleteMapping("/delete")
	public void delete()
	{
		this.subRepo.deleteAll();
	}
	
	@DeleteMapping("/deleteBookByPayIdAndEmail")
 	public String deleteBookByPayIdAndEmail(@RequestParam int payId , @RequestParam String readerEmail){
		
		//return s;
		 Reader r = readerService.getPurchasedBookByPayIdAndEmail(payId , readerEmail);
		 
		 System.out.println(r);
		 
	 if(r!= null) {
		 long hours = ChronoUnit.HOURS.between( r.getPayTime() , LocalDateTime.now());
		 System.out.println(hours);
		 if(hours < 24)
		 {
			  readerService.deleteBookByPayIdAndEmail(payId);
			  return " book deleted" ;
		 }
	 else
		 return " Book cannot be return after 24 hours " ;
		 }
	 
	 else {
		 return " Book Doen't exists in your list " ;
	}
	}
	
	@DeleteMapping("/deleteBookByBookIdAndEmail/{book_id}/{readerEmail}")
 	public Subscription1 deleteBookBySubIdAndEmail(@PathVariable int book_id, @PathVariable String readerEmail){
		
		Subscription1 sub = subRepo1.findByBookIdandReaderEmail(book_id,readerEmail);
		
		System.out.println(sub);
	
		if(sub!= null) {
			 long hours = ChronoUnit.HOURS.between( sub.getPayTime() , LocalDateTime.now());
			 System.out.println(hours);
			 if(hours < 24)
			 {
				  subRepo1.deleteById(sub.getPayId());
				  return sub ;
			 }
			 else {
				 return null;
			 }
		
		
		
	}
		return null;
	
	
	
}
	
	
	
	
}

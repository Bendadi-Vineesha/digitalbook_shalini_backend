package com.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Book;

//@FeignClient(value = "comic", url = "http://localhost:8082/api/v1")
@FeignClient("digitalbook-app")
public interface BookClient {

	@GetMapping("book/api/v1/findBookByCategory")
    List<Book> getBookByCategory( @RequestParam(value="category") String category);
	
	@GetMapping("book/api/v1/findBookByPublisher")
    List<Book> getBookByPublisher(  @RequestParam(value="publisher") String publisher);
	
	@GetMapping("book/api/v1/findBookByAuthor")
    List<Book> getBookByAuthor( @RequestParam(value="author") String author);

	@GetMapping("book/api/v1/findBookByPrice")
    List<Book> getBookByPrice( @RequestParam(value="price") int price);

	@GetMapping("book/api/v1/buyBook")
    Book buyBook( @RequestParam(value="id") int id );
	
	@GetMapping("book/api/v1/subscribeBook")
    Book subscribeBook( @RequestParam(value="id") int id );
	
	@GetMapping("book/api/v1/subscribedBook")
    Book subscribedBook( @RequestParam(value="id") int id );
	
	@GetMapping("book/api/v1/subscribedBookById")
    Book subscribedBookById( @RequestParam(value="id") int id );
	
	@GetMapping("book/api/v1/findAll")
    List<Book> findAll();

	


//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
	
}

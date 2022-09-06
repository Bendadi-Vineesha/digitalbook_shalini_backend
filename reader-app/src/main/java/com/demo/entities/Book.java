package com.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Book {

	
	private int id;
	private String title;
	private String author;
	private  String publisher;
	private LocalDateTime publishDate;
	private String block;
	private String category;
	private String content;
	private int  price;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDateTime getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ",publishDate=\" + publishDate + \", block="
				+ block + ", category=" + category + ", content=" + content + ", price=" + price + "]";
	}
	
	public Book()
	{
		
	}
	public Book(int id,String title, String author, String publisher, LocalDateTime publishDate, String block, String category, String content,
			int  price) {
		
		this(title,  author, publisher, publishDate,  block,  category,  content,
				 price);
		this.id=id;
		this.publishDate= LocalDateTime.now();
		
		
		
	}
	
	public Book(String title, String author, String publisher, LocalDateTime publishDate, String block, String category, String content,
			int price) {
	super();
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.publishDate = publishDate;
		this.block=block;
		this.category=category;
		this.content=content;
		this.price=price;
		
	}
	
	
	
	
	
	
		
	
	
}

package com.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.persistence.TableGenerator;

@Controller
@Entity
public class Reader {

	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int  payId;
	private String readerEmail;
	
	private String readerName;
	private LocalDateTime payTime;
	private int id;
	private String title;
	private String author;
	private  String publisher;
	private LocalDateTime publishDate;
	private String block;
	private String category;
	private String content;
	private int  price;
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getReaderEmail() {
		return readerEmail;
	}
	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public LocalDateTime getPayTime() {
		return payTime;
	}
	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}
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
	@Override
	public String toString() {
		return "Reader [payId=" + payId + ", readerEmail=" + readerEmail + ", readerName=" + readerName + ", payTime="
				+ payTime + ", id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publishDate=" + publishDate + ", block=" + block + ", category=" + category + ", content="
				+ content + ", price=" + price + "]";
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
	public Reader(int payId, String readerEmail, String readerName, LocalDateTime payTime, int id, String title,
			String author, String publisher, LocalDateTime publishDate, String block, String category, String content,
			int price) {
		this(readerEmail, readerName, title,author, publisher,block,category,content,price);
		
		this.payId = payId;
		this.payTime = LocalDateTime.now();
		this.id = id;
		this.publishDate = LocalDateTime.now();
		
	}
	
	public Reader() {
		super();
	}
	public Reader(String readerEmail, String readerName,String title,
			String author, String publisher, String block, String category, String content,
			int price) {
	
		
		this.readerEmail = readerEmail;
		this.readerName = readerName;
		this.title = title;
		this.author = author;;
		this.publisher=publisher;
		this.block = block;
		this.category = category;
		this.content=content;
		this.price=price;
	}
	
	
	

}

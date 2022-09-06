package com.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int  payId;
	private String readerEmail;
	
	private String readerName;
	private LocalDateTime payTime;
	private int book_id;
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
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "Subscription1 [payId=" + payId + ", readerEmail=" + readerEmail + ", readerName=" + readerName
				+ ", payTime=" + payTime + ", book_id=" + book_id + "]";
	}
	public Subscription1(int payId, String readerEmail, String readerName, LocalDateTime payTime, int book_id) {
		this(readerEmail, readerName,book_id);
		this.payId = payId;
		this.payTime = LocalDateTime.now();
		
	}
	
	public Subscription1(String readerEmail, String readerName,int book_id) {
		super();
		this.readerEmail=readerEmail;
		this.readerName=readerName;
		this.book_id=book_id;
		
		
	}
	
	
	public Subscription1() {
		super();
	}
	
	
	
	
	
	
	

}

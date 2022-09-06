package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sub_id;
	private String subscriberName;
	private String subscriberEmail;
	private int book_id;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public String getSubscriberEmail() {
		return subscriberEmail;
	}
	public void setSubscriberEmail(String subscriberEmail) {
		this.subscriberEmail = subscriberEmail;
	}
	
	@Override
	public String toString() {
		return "Subscription [sub_id=" + sub_id + ", subscriberName=" + subscriberName + ", subscriberEmail="
				+ subscriberEmail + ", book_id=" + book_id + "]";
	}
	public Subscription(int sub_id, String subscriberName, String subscriberEmail, int book_id) {
		this(subscriberName, subscriberEmail, book_id);
		this.sub_id = sub_id;
		
	}
	public Subscription(String subscriberName, String subscriberEmail, int book_id) {
		super();
		this.subscriberName = subscriberName;
		this.subscriberEmail = subscriberEmail;
		this.book_id=book_id;
	}
	public Subscription() {
		super();
	}
	
	
	
	
	
	
	

}

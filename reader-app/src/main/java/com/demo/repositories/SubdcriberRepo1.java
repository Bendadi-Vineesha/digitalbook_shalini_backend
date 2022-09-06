package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Reader;
//import com.demo.entities.Subscription;
import com.demo.entities.Subscription1;

public interface SubdcriberRepo1 extends JpaRepository<Subscription1, Integer> {

	@Query("select r from Subscription1 r where r.readerEmail = ?1 ")
	List<Subscription1> findBySubscriberEmail(String subscriberEmail);
	
	@Query("select r from Subscription1 r where r.payId = ?1 and r.readerEmail = ?2")
	public Subscription1 findByPayIdandReaderEmail(int payId, String readerEmail);
	
	public void deleteByPayId(int payId);
	
	@Query("select r from Subscription1 r where r.book_id = ?1 and r.readerEmail = ?2")
	public Subscription1 findByBookIdandReaderEmail(int bookId, String readerEmail);
	
	@Query("delete  from Subscription1 r where r.book_id = ?1 and r.readerEmail = ?2")
	public void deleteByBookId(int book_id, String readerEmail);
	
	
}
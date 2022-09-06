package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Reader;
import com.demo.entities.Subscription;

public interface SubscriberRepo extends JpaRepository<Subscription, Integer> {

	@Query("select r from Subscription r where r.subscriberEmail = ?1 ")
	List<Subscription> findBySubscriberEmail(String subscriberEmail);

}

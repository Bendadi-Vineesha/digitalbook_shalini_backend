package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

@Service
public class KafkaConsumerListener {
	
//	@Autowired
//	BookRepository repo;
//
//    private static final String TOPIC = "kafka-topic";
//    //private static final String TOPIC1 = "book-topic";
//
//    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(Book book) {
//        System.out.println("Consumed JSON Message: " + repo.save(book));
//    }
//    
//    @KafkaListener(topics = TOPIC1, groupId="group_id", containerFactory = "userKafkaListenerFactory")
//    public void consumeJson1(Book book) {
//        System.out.println("Consumed JSON Message: " + book);
//    }
    
}
package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Author;
import com.demo.repositories.AuthorRepo;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepo repo;

	public Author createAuthor(Author a) {
		
		return repo.save(a);
	}

	public List<Author> seeAuthor() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	
	

}

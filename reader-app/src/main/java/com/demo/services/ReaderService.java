package com.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.entities.Reader;
import com.demo.repositories.ReaderRepository;

@Transactional
@Service
public class ReaderService {
	
	

	@Autowired
	private ReaderRepository repo;
	
	public 	Reader saveBook(Reader r) {
		return repo.save(r);
	}

	public List<Reader> getPurchasedBookByEmail(String readerEmail) {
		// TODO Auto-generated method stub
		return repo.findAllByReaderEmail(readerEmail);
	}

	public List<Reader> getPurchasedBookByBookIdAndEmail(int id , String readerEmail) {
		// TODO Auto-generated method stub
		return repo.findByBookId(id , readerEmail);
	}
	public Reader getPurchasedBookByPayIdAndEmail(int payId , String readerEmail) {
		// TODO Auto-generated method stub
		return repo.findByPayId(payId , readerEmail);
	}

	public void deleteBookByPayIdAndEmail(int payId) {
		// TODO Auto-generated method stub
		 repo.deleteByPayId(payId);
	}

	
	
	
} 

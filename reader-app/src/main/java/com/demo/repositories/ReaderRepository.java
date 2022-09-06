package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Book;
import com.demo.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>{

	public Reader save(Reader r);

	public List<Reader> findAllByReaderEmail(String readerEmail);
	
	
@Query("select r from Reader r where r.id = ?1 and r.readerEmail = ?2")
	public List<Reader> findByBookId(int id,String readerEmail);

@Query("select r from Reader r where r.payId = ?1 and r.readerEmail = ?2")
public Reader findByPayId(int payId, String readerEmail);

//@Modifying
//@Query("delete  from Reader r where r.payId = ?1 and r.readerEmail = ?2")
public void deleteByPayId(int payId);


}

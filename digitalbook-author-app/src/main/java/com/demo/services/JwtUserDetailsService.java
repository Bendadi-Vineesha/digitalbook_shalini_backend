package com.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Author;
import com.demo.repositories.AuthorRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AuthorRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Author author = repo.findByUsername(username);
		System.out.print(author);
// find user from database where user = :username
// userRepo.findByUsername(username);// username, password, roles

//		if (author.getUsername().equals(username)) {
//			//return new User(author.getUsername(), "{noop}"+author.getPassword(), new ArrayList<>());
//		return new User(author.getUsername(), "{bcrypt}"+ author.getPassword(), new ArrayList<>());
//			//return new User("demo", "$2a$10$I.9/VzJtdX1IcPPHLT0eY.SW6MM4vTBj62tjmZhGKtLDeHy2/kVdW", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		
		if(author.getUsername().equals(username)) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
        

        // admin@123
		return new User(author.getUsername(), "{noop}"+ author.getPassword(), authorities);
	}  else {
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
	}
}

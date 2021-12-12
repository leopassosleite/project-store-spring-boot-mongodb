package com.xbarts.storemongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.xbarts.storemongo.domain.User;
import com.xbarts.storemongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User leonardo = new User(null, "Leonardo", "leopassos.leite@gmail.com");
		User tailine = new User(null, "Tailine", "tailine.prates@gmail.com");
		User alice = new User(null, "Alice", "alice.coutinho@gmail.com");
		
		userRepository.saveAll(Arrays.asList(leonardo, tailine, alice));
	}

}

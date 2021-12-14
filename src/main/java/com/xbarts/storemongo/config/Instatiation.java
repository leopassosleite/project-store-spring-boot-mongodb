package com.xbarts.storemongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.xbarts.storemongo.domain.Post;
import com.xbarts.storemongo.domain.User;
import com.xbarts.storemongo.dto.AuthorDTO;
import com.xbarts.storemongo.repository.PostRepository;
import com.xbarts.storemongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User leonardo = new User(null, "Leonardo", "leopassos.leite@gmail.com");
		User tailine = new User(null, "Tailine", "tailine.prates@gmail.com");
		User alice = new User(null, "Alice", "alice.coutinho@gmail.com");
		
		userRepository.saveAll(Arrays.asList(leonardo, tailine, alice));
		
		Post post1 = new Post(null, sdf.parse("10/12/2021"), "Produto excelente", "Produto de muita qualidade, recomendo!", new AuthorDTO(leonardo));
		Post post2 = new Post(null, sdf.parse("14/12/2021"), "Pruduto ruim", "Produdo abaixo de minhas expectativas, não recomendo!", new AuthorDTO (tailine));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}

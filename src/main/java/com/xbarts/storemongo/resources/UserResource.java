package com.xbarts.storemongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbarts.storemongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User leonardo = new User("1", "Leonardo dos Passos Leite", "leopassos.leite@gmail.com");
		User tailine = new User("2", "Tailine Prates", "tailine.prates@gmail.com");
		User alice = new User("3", "Alice Coutinho", "alice.coutinho@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(leonardo, tailine, alice));
		return ResponseEntity.ok().body(list);
	}
}

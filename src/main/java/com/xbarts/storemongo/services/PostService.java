package com.xbarts.storemongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbarts.storemongo.domain.Post;
import com.xbarts.storemongo.domain.User;
import com.xbarts.storemongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow();
	}
}

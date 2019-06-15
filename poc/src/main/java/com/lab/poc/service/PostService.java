package com.lab.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.poc.model.Post;
import com.lab.poc.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findOne(Long id) {
		Optional<Post> post = postRepository.findById(id);
		return post.get();
	}

	public Post save(Post post) {
		return postRepository.saveAndFlush(post);
	}

	public void delete(Long id) {
		postRepository.deleteById(id);
	}
}

package com.lab.poc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lab.poc.model.Post;
import com.lab.poc.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", postService.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Post post) {

		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", post);

		return mv;
	}

	@GetMapping("/findOne/{id}")
	public ModelAndView findOne(@PathVariable("id") Long id) {

		return add(postService.findOne(id));
	}

	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		postService.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Post post, BindingResult result) {

		if (result.hasErrors()) {
			return add(post);
		}

		postService.save(post);

		return findAll();
	}
}

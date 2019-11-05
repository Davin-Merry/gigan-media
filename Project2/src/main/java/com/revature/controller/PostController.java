package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Post;
import com.revature.service.PostService;

@Controller
@RequestMapping(value="/post")
@CrossOrigin(origins="*")
public class PostController {
	
	private PostService post;
	
	@GetMapping(value="getAll.app")
	public ResponseEntity<List<Post>> getAll(){
		return new ResponseEntity<List<Post>>(post.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="{email}/getEmailUri.app")
	public @ResponseBody Post selectById(@PathVariable("id") String email) {
		return post.getByEmail(email);
	}
	
	@PostMapping(value="/putIn.app")
	public @ResponseBody Post insert(@RequestBody Post p) {
		System.out.println(p);
		post.insert(p);
		return p;
	}
	
	
	
	public PostService getUser() {
		return post;
	}
	
	@Autowired
	public void setPost(PostService post) {
		this.post = post;
	}
}

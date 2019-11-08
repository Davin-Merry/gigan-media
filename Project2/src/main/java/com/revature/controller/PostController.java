package com.revature.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Post;
import com.revature.model.User;
import com.revature.service.ImageService;
import com.revature.service.PostService;

@Controller
@RequestMapping(value="/post")
@CrossOrigin(origins="*")
public class PostController {
	
	private PostService post;
	private ImageService image;
	
	@GetMapping(value="getAll.app")
	public ResponseEntity<List<Post>> getAll(){
		return new ResponseEntity<List<Post>>(post.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="getByEmail.app")
	public @ResponseBody List<Post> selectById(@RequestParam("id") String email) {
		//return post.getByEmail(email);
		return null;
	}
	
	@PostMapping(value="/putIn.app")
	public @ResponseBody Post insert(@RequestBody Post p) {
		post.insert(p);
		return p;
	}
	
	@PostMapping(value="/likePost.app")
	public @ResponseBody String likePost(@RequestBody Post p) {
		post.update(p);
		return "{\"update\": true}";
	}
	
	@PostMapping(value="uploadPostImage.app")
	public @ResponseBody String uploadPostImage(@RequestParam("id") String id, @RequestParam("type") String type, @RequestBody byte[] f) {
		InputStream file = new ByteArrayInputStream(f);
		String url = image.uploadImage(file, id, type, (long)f.length);
		return "{\"newURL\": \"" + url + "\"}";
	}
	
	public PostService getUser() {
		return post;
	}
	
	@Autowired
	public void setPost(PostService post) {
		this.post = post;
	}
	
	public ImageService getImage() {
		return image;
	}
	
	@Autowired
	public void setImage(ImageService image) {
		this.image = image;
	}
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Post;
import com.revature.repo.PostRepo;

@Service
public class PostService {

	private PostRepo rp; 
	
	
	
	public List<Post> getAll(){
		return rp.selectAll(); 
	}
	
	public Post getById(int id) {
		return rp.selectById(id); 
	}
	
	public void update(Post p) {
		rp.update(p); 
	}
	
	public void insert(Post p) {
		rp.insert(p);
	}
	
	//Example had a getRp method. Don't think we need it
	
	@Autowired
	public void setRp(PostRepo rp) {
		this.rp = rp;
	}

	public Post getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}

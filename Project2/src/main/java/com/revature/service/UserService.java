package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.User;
import com.revature.repo.UserRepo;

public class UserService {
	
private UserRepo ur; 
	
	public List<User> getAll() {
		return ur.selectAll();
	}
	
	public User getByEmail(String email) {
		User u = ur.selectByEmail(email);
		
		if (u!=null) {
		u.setPassword("");
		}
		
		return u; 		
	}
	
	public void update(User u) {
		ur.update(u);
	}
	
	public void insert(User u) {
		ur.update(u);
		
	}
	
	@Autowired
	public void setBr(UserRepo ur) {
		this.ur = ur; 
	}

}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repo.UserRepo;

@Service
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
	
	public void delete(String u) {
		ur.delete(u);
	}
	
	public void insert(User u) {
		ur.insert(u);
		
	}
	
	@Autowired
	public void setBr(UserRepo ur) {
		this.ur = ur; 
	}

}

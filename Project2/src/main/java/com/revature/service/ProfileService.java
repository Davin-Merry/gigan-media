package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Profile;
import com.revature.repo.ProfileRepo;

@Service
public class ProfileService {

private ProfileRepo pr; 
	
	public List<Profile> getAll() {
		return pr.selectAll();
	}
	
	public Profile getByEmail(String email) {
		return pr.selectByEmail(email);
	}
	
	public void update(Profile p) {
		pr.update(p);
	}
	
	public void insert(Profile p) {
		pr.update(p);
		
	}
	
	
	@Autowired
	public void setPr(ProfileRepo pr) {
		this.pr = pr; 
	}

}

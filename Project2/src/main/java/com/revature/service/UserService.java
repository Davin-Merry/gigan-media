package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;
import com.revature.repo.UserRepo;
import com.revature.util.SecurityUtil;

@Service
public class UserService {
	
	private UserRepo ur;
	
	public List<User> getAll() {
		return ur.selectAll();
	}
	
	/**
	 * This method validates the user using the email and password.
	 * 
	 * @param email
	 * @param pass is the password
	 * @return user
	 */
	
	public User getByLogin(String email, String pass) {
		User u = ur.selectByEmail(email);
		
		if (u!=null) {
			SecurityUtil su = new SecurityUtil();
			if (!su.hashSha256(pass, u.getSalt()).equals(u.getPassword())) {
				//If the password given doesn't match the user's, don't pass the user down.
				u = null;
			} else {
				//Wipe out password and salt before handing the object over.
				u.setPassword("");
				u.setSalt("");
			}
		}
		
		return u;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	
	
	public User getByEmail(String email) {
		User u = ur.selectByEmail(email);
		u.setPassword("");
		u.setSalt("");
		return u;
	}
	
	public void update(User u) {
		/*
		if (u.getPassword() != null) {
			SecurityUtil su = new SecurityUtil();
			u.setSalt(su.generateSalt());
			u.setPassword(su.hashSha256(u.getPassword(), u.getSalt()));
			ur.update(u);
		}
		*/
		ur.update(u);
	}
	
	public void delete(String u) {
		ur.delete(u);
	}
	
	/**
	 * After encryption, it inserts the password into the database
	 * 
	 * @param u is the user to be inserted.
	 */
	
	public void insert(User u) {
		SecurityUtil su = new SecurityUtil();
		u.setSalt(su.generateSalt());
		u.setPassword(su.hashSha256(u.getPassword(), u.getSalt()));
		ur.insert(u);
	}
	
	@Autowired
	public void setBr(UserRepo ur) {
		this.ur = ur; 
	}

}

package com.revature.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
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

import com.revature.model.User;
import com.revature.service.ImageService;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	private UserService user;
	private ImageService image;
	
   
	
	@GetMapping(value="/userInfo.app", params = {"email"})
	public @ResponseBody User getUserInfo(String email) {
		
		logger.info("This is an info log entry");
	    logger.error("This is an error log entry");
		return user.getByEmail(email.toLowerCase());
		  
	}
	
	@PostMapping(value="/processLogin.app", produces="application/json")
	public @ResponseBody User bringBackByEmail(@RequestBody User u) {
		logger.info("This is an info log entry 2");
	    logger.error("This is an error log entry 2");
		return user.getByLogin(u.getEmail().toLowerCase(), u.getPassword());
	}
	
	@GetMapping(value="getAll.app")
	public ResponseEntity<List<User>> getAll(){
		logger.info("This is an info log entry 3");
	    logger.error("This is an error log entry 3");
		return new ResponseEntity<List<User>>(user.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="updateInfo.app")
	public @ResponseBody String updateUser(@RequestBody User u) {
		user.update(u);
		
		logger.info("This is an info log entry 4");
	    logger.error("This is an error log entry 4");
		return "{\"update\": true}";
	}
	
	@PostMapping(value="updatePassword.app")
	public @ResponseBody String updatePassword(@RequestBody User u) {
		user.updatePassword(u);
		return "{\"update\": true}";
	}
	
	@PostMapping(value="updateProfilePic.app", consumes= {"image/*"})
	public @ResponseBody String updateProfilePic(@RequestParam String id, @RequestParam String type, @RequestBody byte[] f) {
		InputStream file = new ByteArrayInputStream(f);
		String url = image.uploadProfile(file, id, type, (long)f.length);
		user.updateProfileByEmail(id, url);
		logger.info("This is an info log entry 5");
	    logger.error("This is an error log entry 5");
		return "{\"newURL\": \"" + url + "\"}";
	}
	
	@PostMapping(value="/putIn.app")
	public @ResponseBody User insert(@RequestBody User u) {
		user.insert(u);
		logger.info("This is an info log entry 6");
	    logger.error("This is an error log entry 6");
		return u;
	}
	
	public UserService getUser() {
		return user;
	}
	
	@Autowired
	public void setUser(UserService user) {
		this.user = user;
	}
	
	public ImageService getImage() {
		return image;
	}
	
	@Autowired
	public void setImage(ImageService image) {
		this.image = image;
	}
}

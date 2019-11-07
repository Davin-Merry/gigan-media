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

import com.revature.model.User;
import com.revature.service.ImageService;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {
	
	private UserService user;
	private ImageService image;
	
	@GetMapping(value="/userInfo.app", params = {"email"})
	public @ResponseBody User getUserInfo(String email) {
		return user.getByEmail(email.toLowerCase());
	}
	
	@PostMapping(value="/processLogin.app", produces="application/json")
	public @ResponseBody User bringBackByEmail(@RequestBody User u) {
		return user.getByLogin(u.getEmail().toLowerCase(), u.getPassword());
	}
	
	@GetMapping(value="getAll.app")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(user.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="updateInfo.app")
	public @ResponseBody String updateUser(@RequestBody User u) {
		user.update(u);
		return "{\"update\": true}";
	}
	
	@PostMapping(value="updateProfilePic.app", consumes= {"image/*"})
	public @ResponseBody String updateProfilePic(@RequestParam String id, @RequestParam String type, @RequestBody byte[] f) {
		InputStream file = new ByteArrayInputStream(f);
		String url = image.uploadProfile(file, id, type, (long)f.length);
		user.updateProfileByEmail(id, url);
		return "{\"newURL\": \"" + url + "\"}";
	}
	
	@PostMapping(value="/putIn.app")
	public @ResponseBody User insert(@RequestBody User u) {
		user.insert(u);
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

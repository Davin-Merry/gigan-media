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
import com.revature.service.UserService;
import com.revature.wrapper.FileInfoContext;

@Controller
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {
	
	private UserService user;
	
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
	
	@PostMapping(value="updateProfilePic.app")
	public @ResponseBody String updateProfilePic(@RequestParam String id, @RequestBody byte[] f) {
		InputStream file = new ByteArrayInputStream(f);
		System.out.println(f.length);
		System.out.println(id.toLowerCase());
		return "{\"update\": true}";
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
}

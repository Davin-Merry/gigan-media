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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@Controller
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {
	
	private UserService user;
	
	/*
	 * There really is no need for a method like this. We may need to remove it in the future.
	 */
	@Deprecated
	@GetMapping(value="/delete.application",params= {"id"})
	public @ResponseBody String delete(String email) {
		user.delete(email);
		return "YOUR ACCOUNT HAS BEEN EXTERMINATED";
	}
	
	
	@RequestMapping(value="/getEmail.application", method=RequestMethod.POST,
			produces="application/json", params= {"email"})
	public @ResponseBody User bringBackByEmail(String email) {
		return user.getByEmail(email);
	}
	
	@GetMapping(value="getAll.application")
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<List<User>>(user.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="{email}/getEmailUri.application")
	public @ResponseBody User selectById(@PathVariable("id") String email) {
		return user.getByEmail(email);
	}
	
	@PostMapping(value="/putIn.application")
	public @ResponseBody User insert(@RequestBody User u) {
		System.out.println(u);
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

	public UserController() {
		System.out.println("controller");
	}

}

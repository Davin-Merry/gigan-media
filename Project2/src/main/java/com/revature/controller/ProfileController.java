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

import com.revature.model.Profile;
import com.revature.service.ProfileService;

@RestController
@Controller
@RequestMapping(value="/profile")
@CrossOrigin(origins="*")
public class ProfileController {
	
	private ProfileService profile;
	
		@GetMapping(value="getAll.application")
		public ResponseEntity<List<Profile>> getAll(){
			return new ResponseEntity<List<Profile>>(profile.getAll(), HttpStatus.OK);
		}
		
		@PostMapping(value="{email}/getEmailUri.application")
		public @ResponseBody Profile selectById(@PathVariable("id") String email) {
			return profile.getByEmail(email);
		}
		
		@PostMapping(value="/putIn.application")
		public @ResponseBody Profile insert(@RequestBody Profile p) {
			System.out.println(p);
			profile.insert(p);
			return p;
		}
		
		
		
		public ProfileService getUser() {
			return profile;
		}
		
		@Autowired
		public void setProfile(ProfileService profile) {
			this.profile = profile;
		}
	
		public ProfileController() {
			System.out.println("controller");
		}
	

}

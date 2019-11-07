package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.service.UserService;

	public class TestUser {
		
		public UserService us = new UserService(); 
		
		
		@Test
		public void getByLogin() {
			
			assertEquals("Jean-Luc", us.getByLogin("star.trek@gmail.com", "star").getFirstName()); 
			
		}


	}
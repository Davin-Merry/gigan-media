package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Transactional
@Repository()
public class UserRepo {

		static {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private SessionFactory sesFact;
		
		public void insert(User u) {
			sesFact.getCurrentSession().save(u);
		}
		
		/**
		 * The goto update function for our users. If either personal info,
		 * password, or profile picture gets updated, we pass it here.
		 * 
		 * @param u The user object to update
		 */
		public void update(User u) {
			User user = sesFact.getCurrentSession().get(User.class, u.getEmail());
			System.out.println("Before: " + user);
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setPassword(u.getPassword());
			user.setSalt(u.getSalt());
			user.setProfileImage(u.getProfileImage());
			user.setBio(u.getBio());
			user.setGalaxy(u.getGalaxy());
			user.setPlanet(u.getPlanet());
			
			System.out.println("After: " + user);
			sesFact.getCurrentSession().update(user);
		}
		
		public User selectByFirstName(String firstName) {
			User u = sesFact.getCurrentSession().get(User.class, firstName);
			return u;
		}
		
		public User selectByEmail(String email) {
			User u = sesFact.getCurrentSession().get(User.class, email);
			return u;
		}
		
		public List<User> selectAll(){
		List <User> list = sesFact.getCurrentSession().createQuery("from User", User.class).list();
		return list; 
		}
		
		public void delete(String u) {
			// TODO Auto-generated method stub
			
		}
		
		@Autowired
		public UserRepo(SessionFactory sesFact) {
			this.sesFact = sesFact;
		}
}

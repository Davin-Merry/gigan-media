package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Profile;

@Transactional
@Repository()
public class ProfileRepo  {
			
		static {try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		
		private SessionFactory sesFact;
		
		public void insert(Profile p) {
			sesFact.getCurrentSession().save(p);
		}
		
		public Profile selectByEmail(String email) {
			Profile p = sesFact.getCurrentSession().load(Profile.class, email);
			return p;
		}
		
		public List<Profile> selectAll(){
		List <Profile> list = sesFact.getCurrentSession().createQuery("from Profile", Profile.class).list();
		return list; 
		}
		
		@Autowired
		public ProfileRepo(SessionFactory sesFact) {
			this.sesFact = sesFact;
		}
	}




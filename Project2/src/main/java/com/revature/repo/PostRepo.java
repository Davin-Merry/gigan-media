package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Post;

@Transactional
@Repository()
public class PostRepo {
	
	static {try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}
	
	private SessionFactory sesFact;
	
	public void insert(Post p) {
		sesFact.getCurrentSession().save(p);
	}
	
	public void update(Post p) {
		sesFact.getCurrentSession().update(p);
	}
	
	public Post selectById(int id) {
		Post p = sesFact.getCurrentSession().get(Post.class, id);
		return p;
	}
	
	public List<Post> selectAll(){
	List <Post> list = sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
	return list; 
	}
	
	@Autowired
	public PostRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
}

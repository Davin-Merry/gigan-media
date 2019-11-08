package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
//	public List<Post> selectAllByEmail(String email) {
//		/*
//		Query<Post> q = sesFact.getCurrentSession().createQuery("FROM Post WHERE Post.blogger.email=?1", Post.class);
//		q.setParameter(1, email);
//		List<Post> list = q.list();
//		*/
//		return null;
//	}
	
	public List<Post> selectAll(){
	List <Post> list = sesFact.getCurrentSession().createQuery("from Post", Post.class).list();
	System.out.println(list);
	return list; 
	}
	
	@Autowired
	public PostRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
}

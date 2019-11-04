package com.revature.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_posts")
public class Post {
    
    @Id
    @Column(name = "postId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int postId;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "userPost")
    private User user;
   
    @Column(name = "text")
    private String text;
    
    @ElementCollection
    @Column(name = "picture")
    private List<String> images;
    
    @Column(name = "time")
    private Timestamp time; 
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="user_likes", joinColumns=@JoinColumn(name="email"),
    					   inverseJoinColumns=@JoinColumn(name="post_id"))
    private Set<User> likes = new HashSet<User>();// many to many
    
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set<User> getLikes() {
		return likes;
	}

	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, images, likes, postId, text, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(user, other.user) && Objects.equals(images, other.images)
				&& Objects.equals(likes, other.likes) && postId == other.postId && Objects.equals(text, other.text)
				&& Objects.equals(time, other.time);
	}

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, User user, String text, List<String> images, Timestamp time, Set<User> likes) {
		super();
		this.postId = postId;
		this.user = user;
		this.text = text;
		this.images = images;
		this.time = time;
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", User=" + user + ", text=" + text + ", images=" + images
				+ ", time=" + time + ", likes=" + likes + "]";
	}
    
   
}
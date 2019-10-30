package com.revature.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Post {
	
	private User creator; 
	private String text;
	private List<String> images; 
	private Timestamp time; 
	private Set<User> likes;
	
	public User getCreator() {
		return creator;
	}
	
	public void setCreator(User creator) {
		this.creator = creator;
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
		return Objects.hash(creator, images, likes, text, time);
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
		return Objects.equals(creator, other.creator) && Objects.equals(images, other.images)
				&& Objects.equals(likes, other.likes) && Objects.equals(text, other.text)
				&& Objects.equals(time, other.time);
	}
	
	public Post(User creator, String text, List<String> images, Timestamp time, Set<User> likes) {
		super();
		this.creator = creator;
		this.text = text;
		this.images = images;
		this.time = time;
		this.likes = likes;
	}
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Post [creator=" + creator + ", text=" + text + ", images=" + images + ", time=" + time + ", likes="
				+ likes + "]";
	}
}

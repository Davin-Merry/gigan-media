package com.revature.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Post {
	
	private int postId; 
	private User creator; 
	private String text;
	private List<String> images; 
	private Timestamp time; 
	private Set<User> likes;
	
<<<<<<< HEAD
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
	
=======
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}
	/**
	 * @param images the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}
	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}
	/**
	 * @return the likes
	 */
	public Set<User> getLikes() {
		return likes;
	}
	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Set<User> likes) {
		this.likes = likes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
>>>>>>> 5b1fcc07963654e0ac5eb8b2f94baf28ef400a32
	@Override
	public int hashCode() {
		return Objects.hash(creator, images, likes, postId, text, time);
	}
<<<<<<< HEAD
	
=======
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
>>>>>>> 5b1fcc07963654e0ac5eb8b2f94baf28ef400a32
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
				&& Objects.equals(likes, other.likes) && postId == other.postId && Objects.equals(text, other.text)
				&& Objects.equals(time, other.time);
	}
<<<<<<< HEAD
	
	public Post(User creator, String text, List<String> images, Timestamp time, Set<User> likes) {
=======
	public Post(int postId, User creator, String text, List<String> images, Timestamp time, Set<User> likes) {
>>>>>>> 5b1fcc07963654e0ac5eb8b2f94baf28ef400a32
		super();
		this.postId = postId;
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
<<<<<<< HEAD
	
	@Override
	public String toString() {
		return "Post [creator=" + creator + ", text=" + text + ", images=" + images + ", time=" + time + ", likes="
				+ likes + "]";
	}
=======
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", creator=" + creator + ", text=" + text + ", images=" + images + ", time="
				+ time + ", likes=" + likes + "]";
	}
	
>>>>>>> 5b1fcc07963654e0ac5eb8b2f94baf28ef400a32
}
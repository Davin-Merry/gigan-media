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

import com.revature.model.User;

/**
 * This is a model that identifies the user's posts and holds its attributes.
 * 
 * @entity annotation creates the table to store a user post.
 * 
 * @table this table is referenced as app_post
 * 
 * @author gigan J J
 *
 *
 */

@Entity
@Table(name="app_post")
public class Post {
    
    @Id
    @Column(name = "post_postId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int postId;
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "post_user")
    private User blogger;
   
    @Column(name = "post_text")
    private String text;
    
    //@ElementCollection
    @Column(name = "post_images")
    private String images;
    
    @Column(name = "post_time")
    private Timestamp time; 
    
    /**
     *The inverse join column stores the list of user likes.Hashset is used to 
     *restrict users from recording more than one likes for each post.
     */
    /* Unfortunately, this variable is defunct, due to the lack of knowledge on how to implement this properly.
     * - Davin M.
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="user_likes", joinColumns=@JoinColumn(name="parent_id"),
    					   inverseJoinColumns=@JoinColumn(name="child_id"))
    private Set<User> likes = new HashSet<User>();// many to many
    */
    
    @Column(name = "user_likes")
    private int likes;
    
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getBlogger() {
		return blogger;
	}

	public void setBlogger(User blogger) {
		this.blogger = blogger;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogger == null) ? 0 : blogger.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + likes;
		result = prime * result + postId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
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
		if (blogger == null) {
			if (other.blogger != null)
				return false;
		} else if (!blogger.equals(other.blogger))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (likes != other.likes)
			return false;
		if (postId != other.postId)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, User blogger, String text, String images, Timestamp time, int likes) {
		super();
		this.postId = postId;
		this.blogger = blogger;
		this.text = text;
		this.images = images;
		this.time = time;
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", blogger=" + blogger + ", text=" + text + ", images=" + images + ", time="
				+ time + ", likes=" + likes + "]";
	}
    
   
}
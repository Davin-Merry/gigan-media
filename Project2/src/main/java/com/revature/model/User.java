package com.revature.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.revature.model.Post; 

@Entity
@Table(name="app_user")
public class User {
    @Id
    @JoinColumn(name = "user_email")
    private String email;
    
    @Column(name = "user_firstName")
    private String firstName;
    
    @Column(name = "user_lastName")
    private String lastName;
    
    @Column(name = "user_password")
    private String password;
    
    @Column(name = "user_profileImage")
    private String profileImage;
    
    @Column(name = "user_bio")
    private String bio;
    
    @Column(name = "user_galaxy")
    private String galaxy;
    
    @Column(name = "user_solarSystem")
    private String solarSystem;
    
    @Column(name = "user_planet")
    private String planet;
    
    /*
    @OneToMany(mappedBy="blogger", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Post> posts;
    */
    
    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }    
    
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getGalaxy() {
        return galaxy;
    }
    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }
    public String getSolarSystem() {
        return solarSystem;
    }
    public void setSolarSystem(String solarSystem) {
        this.solarSystem = solarSystem;
    }
    public String getPlanet() {
        return planet;
    }
    public void setPlanet(String planet) {
        this.planet = planet;
    }
    /*
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    */

	public User(String email, String firstName, String lastName, String password, String profileImage, String bio,
			String galaxy, String solarSystem, String planet) {//, List<Post> posts) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.profileImage = profileImage;
		this.bio = bio;
		this.galaxy = galaxy;
		this.solarSystem = solarSystem;
		this.planet = planet;
		//this.posts = posts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((galaxy == null) ? 0 : galaxy.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((planet == null) ? 0 : planet.hashCode());
		result = prime * result + ((profileImage == null) ? 0 : profileImage.hashCode());
		result = prime * result + ((solarSystem == null) ? 0 : solarSystem.hashCode());
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
		User other = (User) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (galaxy == null) {
			if (other.galaxy != null)
				return false;
		} else if (!galaxy.equals(other.galaxy))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (planet == null) {
			if (other.planet != null)
				return false;
		} else if (!planet.equals(other.planet))
			return false;
		if (profileImage == null) {
			if (other.profileImage != null)
				return false;
		} else if (!profileImage.equals(other.profileImage))
			return false;
		if (solarSystem == null) {
			if (other.solarSystem != null)
				return false;
		} else if (!solarSystem.equals(other.solarSystem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", profileImage=" + profileImage + ", bio=" + bio + ", galaxy=" + galaxy + ", solarSystem="
				+ solarSystem + ", planet=" + planet + "]";
	}
      
}
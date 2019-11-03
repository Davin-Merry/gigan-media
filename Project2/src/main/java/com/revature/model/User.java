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
@Table(name="user")
public class User {
    @Id
    @JoinColumn(name = "email")
    private String email;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "profilePic")
    private String profileImage;
    
    @Column(name = "bio")
    private String bio;
    
    @Column(name = "galaxy")
    private String galaxy;
    
    @Column(name = "solarSystem")
    private String solarSystem;
    
    @Column(name = "planet")
    private String planet;
    
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Post> post;
    
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
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }

	public User(String email, String firstName, String lastName, String password, String profileImage, String bio,
			String galaxy, String solarSystem, String planet, List<Post> post) {
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
		this.post = post;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(bio, email, firstName, galaxy, lastName, post, password, planet, profileImage,
				solarSystem);
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
		return Objects.equals(bio, other.bio) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(galaxy, other.galaxy)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(post, other.post)
				&& Objects.equals(password, other.password) && Objects.equals(planet, other.planet)
				&& Objects.equals(profileImage, other.profileImage) && Objects.equals(solarSystem, other.solarSystem);
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", profileImage=" + profileImage + ", bio=" + bio + ", galaxy=" + galaxy + ", solarSystem="
				+ solarSystem + ", planet=" + planet + ", liked=" + post + "]";
	}
      
}
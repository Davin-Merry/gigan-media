package com.revature.model;

import java.util.Objects;
//HIBERNATE ANNOTATIONS
public class Profile {
	private String profileImage;
	private String bio;
	private String galaxy;
	private String solarSystem;
	private String planet;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(bio, email, galaxy, planet, profileImage, solarSystem);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(bio, other.bio) && Objects.equals(email, other.email)
				&& Objects.equals(galaxy, other.galaxy) && Objects.equals(planet, other.planet)
				&& Objects.equals(profileImage, other.profileImage) && Objects.equals(solarSystem, other.solarSystem);
	}

	public Profile(String profileImage, String bio, String galaxy, String solarSystem, String planet, String email) {
		super();
		this.profileImage = profileImage;
		this.bio = bio;
		this.galaxy = galaxy;
		this.solarSystem = solarSystem;
		this.planet = planet;
		this.email = email;
	}

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [profileImage=" + profileImage + ", bio=" + bio + ", galaxy=" + galaxy + ", solarSystem="
				+ solarSystem + ", planet=" + planet + ", email=" + email + "]";
	}
	

}

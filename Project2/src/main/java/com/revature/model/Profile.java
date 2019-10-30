package com.revature.model;

public class Profile {
	private String profileImage;
	private String bio;
	private String galaxy;
	private String solarSystem;
	private String planet;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((galaxy == null) ? 0 : galaxy.hashCode());
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
		Profile other = (Profile) obj;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (galaxy == null) {
			if (other.galaxy != null)
				return false;
		} else if (!galaxy.equals(other.galaxy))
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
	
	public Profile(User owner, String profileImage, String bio, String galaxy, String solarSystem, String planet) {
		super();
		this.profileImage = profileImage;
		this.bio = bio;
		this.galaxy = galaxy;
		this.solarSystem = solarSystem;
		this.planet = planet;
	}
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Profile [profileImage=" + profileImage + ", bio=" + bio + ", galaxy=" + galaxy + ", solarSystem="
				+ solarSystem + ", planet=" + planet + "]";
	} 
}

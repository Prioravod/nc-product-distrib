package model;

public class Geotag {
	private String name;
	private float latitude;
	private float longitude;
	
	public Geotag(String name, float latitude, float longitude) {
		this.name = name;
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
}

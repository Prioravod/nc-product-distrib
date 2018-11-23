package model;

/** Geotag to indicate the location of the store on the map and stores 
 *  the latitude and 
 *  longitude
 */
public class Geotag {
	private String name;
	public float latitude;
	public float longitude;
	
	public Geotag(String name, float latitude, float longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}

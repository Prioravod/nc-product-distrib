package model;

/** Geotag to indicate the location of the store on the map and stores 
 *  the latitude and 
 *  longitude
 */
public class Geotag {
	private String name;
	public double latitude;
	public double longitude;
	
	public Geotag(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}

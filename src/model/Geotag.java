package model;

import lombok.Getter;
import lombok.Setter;

/** Geotag to indicate the location of the store on the map and stores 
 *  the latitude and 
 *  longitude
 */
public class Geotag {
	@Getter @Setter private String name;
	@Getter @Setter private double latitude;
	@Getter @Setter private double longitude;
	
	public Geotag(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}



}

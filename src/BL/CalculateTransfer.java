package BL;

import model.*;

public class CalculateTransfer {

	public static double getVector(Factory factory, Shop shop) {
		Geotag gt1 = factory.geotag;
		Geotag gt2 = shop.location;		
		return getVector(gt1,gt2);
	}
	public static double getVector(Geotag gt1, Geotag gt2) {
		double lat1Rad = gt1.latitude * Math.PI / 180;
		double lat2Rad = gt2.latitude * Math.PI / 180;
		double long1Rad = gt1.longitude * Math.PI / 180;
		double long2Rad = gt2.longitude * Math.PI / 180;
		return Math.acos(
				Math.sin(lat1Rad) * Math.sin(lat2Rad) +
				Math.cos(lat1Rad) * Math.cos(lat2Rad) *
				Math.cos(long1Rad - long2Rad)				
				)*6371;
	}
	
}

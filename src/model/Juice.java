package model;

import java.time.LocalDateTime;

public class Juice extends Product {
	private static int curr_id;
	private int volume; // in ml

	public Juice(String productName, int shelfLife, long price, int volume) {
		this.id = curr_id++;
		this.productName = productName;
		this.manufDate = LocalDateTime.now();
		this.disqDate = LocalDateTime.now().plusMonths(shelfLife);
		this.price = price;	
		this.volume = volume;
	}
	
	public void setDescription(String discription) {
		this.discription = discription;
		
	}
	
	

}

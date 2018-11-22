package model;

import java.time.LocalDateTime;

public class Demand {
	private static int curr_id;
	private int id;
	private Product productType;
	private int count;
	private LocalDateTime date;
	
	public Demand(Product productType, int count) {
		this.id = curr_id++;
		this.productType = productType;
		this.count = count;
		this.date = LocalDateTime.now();
	}	
}

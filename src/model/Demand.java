package model;

import java.time.LocalDateTime;
import java.util.List;

/** Demand that stores information about 
 *  existing companies, 
 *  the required product, 
 *  its quantity, 
 *  the date-time of the request and 
 *  the store where the request came from
 */
public class Demand {
	private static int curr_id;
	public static List<Company> companies;
	public int id;
	public Product productType;
	public int count;
	public LocalDateTime date;
	public Shop shop;
	
	
	public Demand(Product productType, int count,Shop shop) {
		this.id = curr_id++;
		this.productType = productType;
		this.count = count;
		this.date = LocalDateTime.now();
		this.shop = shop;
	}
}

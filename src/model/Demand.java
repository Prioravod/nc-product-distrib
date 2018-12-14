package model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/** Demand that stores information about 
 *  existing companies, 
 *  the required product, 
 *  its quantity, 
 *  the date-time of the request and 
 *  the store where the request came from
 */
public class Demand {
	
	private static int currId;
	@Getter private int id;
	@Getter @Setter private Map<Product,Integer> products;
	@Getter @Setter private LocalDateTime date;
	@Getter @Setter private Shop shop;
	
	
	public Demand(Map<Product,Integer> products,Shop shop) {
		this.id = currId++;
		this.products = products;
		this.date = LocalDateTime.now();
		this.shop = shop;
	}
}

package model;

import java.time.LocalDateTime;
import java.util.List;

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
	@Getter @Setter private static List<Company> companies;
	@Getter @Setter private Product productType;
	@Getter @Setter private int count;
	@Getter @Setter private LocalDateTime date;
	@Getter @Setter private Shop shop;
	
	
	public Demand(Product productType, int count,Shop shop) {
		this.id = currId++;
		this.productType = productType;
		this.count = count;
		this.date = LocalDateTime.now();
		this.shop = shop;
	}
}

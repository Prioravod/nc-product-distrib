package model;

import lombok.Getter;
import lombok.Setter;

/** Abstract class that defines 
 *  the base state of the object to children, 
 *  is the parent for all classes describing food */
public abstract class Product {
	
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String productName;
	@Getter @Setter private String discription;
	@Getter @Setter private Company company;
	@Getter @Setter private long price;	
		
	public Product(Company company,String productName, long price) {
		this.company = company;
		this.productName = productName;
		this.price = price;	
		this.id = currId++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj.getClass() != this.getClass()) return false;
		if (obj.equals(null)) return false;
		if (
				((Product)obj).productName == this.productName &&
				((Product)obj).price == this.price
			) return true;
		return false;
	}
	@Override
	public int hashCode() {
		return id+productName.chars().reduce((x,y)->(x+y)).getAsInt();
	}
	
}

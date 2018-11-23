package model;

/** Abstract class that defines 
 *  the base state of the object to children, 
 *  is the parent for all classes describing food */
public abstract class Product {
	public int id;
	public String productName;
	public String discription;
	public Company company;
	public long price;	
	private static int curr_id;
	
	public Product() {
		this.id = curr_id++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj.equals(null)) return false;
		if (
				((Product)obj).productName == this.productName &&
				((Product)obj).discription == this.discription &&
				((Product)obj).price == this.price
			) return true;
		return false;
	}
	@Override
	public int hashCode() {
		return id+productName.chars().reduce((x,y)->(x+y)).getAsInt();
	}
}

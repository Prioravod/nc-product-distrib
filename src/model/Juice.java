package model;

import lombok.Getter;
import lombok.Setter;

/** Juice is the descendants of the class Product, has 
 *  a volume
 */
public class Juice extends Product {	
	
	@Getter @Setter private int volume; // in ml

	public Juice(Company company,String productName, long price, int volume) {
		super(company, productName, price);
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		return getProductName() + " '" + getCompany().getCompanyName() + "' " + (volume/1000) + " litres / " + getPrice() + " rubles";
	}
}

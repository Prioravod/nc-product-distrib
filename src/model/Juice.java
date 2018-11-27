package model;

/** Juice is the descendants of the class Product, has 
 *  a volume
 */
public class Juice extends Product {	
	
	public int volume; // in ml

	public Juice(Company company,String productName, long price, int volume) {
		this.company = company;
		this.productName = productName;
		this.price = price;	
		this.volume = volume;
	}
	
	public void setDescription(String discription) {
		this.discription = discription;		
	}
	@Override
	public String toString() {
		return productName + " '" + company.companyName + "' " + (volume/1000) + " litres / " + price + " rubles";
	}
}

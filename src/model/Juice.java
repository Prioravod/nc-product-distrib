package model;

public class Juice extends Product {	
	private int volume; // in ml

	public Juice(String productName, long price, int volume) {
		this.productName = productName;
		this.price = price;	
		this.volume = volume;
	}
	
	public void setDescription(String discription) {
		this.discription = discription;		
	}
	@Override
	public String toString() {
		return productName + " " + (volume/1000) + " litres / " + price + " rubles";
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (obj.equals(null)) return false;
//		if (
//				((Juice)obj).productName == this.productName;
//				((Juice)obj).)
//	}
}

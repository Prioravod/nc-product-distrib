package model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Product> products;
	
	public Basket() {
		this.products = new ArrayList<>();
	}

	public Product get(int index) {
		return products.get(index);
	}
	
	public List<Product> getAll() {
		List<Product> newproducts = products;
		products = null;
		return newproducts;
	}
	public List<Product> viewAll(){
		return products;
	}
	
	public void add(Product item) {
		products.add(item);
	}

	public void addNewProducts(List<Product> newProducts) {
		products.addAll(newProducts);
	}
}

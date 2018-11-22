package model;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	private static int curr_id;
	private int id;
	private String factoryName;
	private List<ProductionItem> production;
	
	/** Production unit, describes the type of object produced 
	 *  and the performance over a period of time (the number of units per year) 
	 */
	public class ProductionItem {
		private Product item;
		private int performance;
		public ProductionItem(Product item, int performance) {
			this.item = item;
			this.performance = performance;
		}		
	}
	
	public Factory(String factoryName) {
		this.id = curr_id++;
		this.factoryName = factoryName;
		this.production = new ArrayList<>();
	}

	public void setProductionItem(Product product,int performance) {
		production.add(new ProductionItem(product,performance));
	}

	
	
	
}

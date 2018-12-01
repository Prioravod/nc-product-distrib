package model;

import lombok.Getter;
import lombok.Setter;

/** Factory producing 
 *  a certain type of product with 
 *  a certain performance and 
 *  geotag
 */
public class Factory {
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String factoryName;
	@Getter @Setter private ProductionItem production;
	@Getter @Setter private int defaultPerformance = 15;
	@Getter @Setter private Geotag geotag;
	
	/** Production unit, describes 
	 *  the type of object produced and 
	 *  the performance over a period of time (the number of units per year) 
	 */
	public class ProductionItem {
		public Product item;
		public int performance;
		public ProductionItem(Product item, int performance) {
			this.item = item;
			this.performance = performance;
		}		
	}
	public Factory(String factoryName,Product product) {
		this.id = currId++;
		this.factoryName = factoryName+id;
		this.production = new ProductionItem(product,defaultPerformance);
	}
	public Factory(String factoryName,Product product,Geotag geotag) {
		this.id = currId++;
		this.factoryName = factoryName+id;
		this.production = new ProductionItem(product,defaultPerformance);
		this.geotag = geotag;
	}

	public void setAnotherProduction(Product product,int performance) {
		production = new ProductionItem(product,performance);
	}
}

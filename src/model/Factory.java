package model;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/** Factory producing 
 *  a certain type of product with 
 *  a certain performance and 
 *  geotag
 */
public class Factory{
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String factoryName;
	@Getter @Setter private ProductionItem production;
	@Getter @Setter private int defaultPerformance = 15;
	@Getter @Setter @NonNull private Geotag geotag;
	@Getter @Setter private List<Transport> transportList;
	
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
	public Factory(String companyName,Product product,Geotag geotag) {
		this.id = currId++;
		this.factoryName = companyName+id;
		this.production = new ProductionItem(product,defaultPerformance);
		this.geotag = geotag;
	}

	public void setAnotherProduction(Product product,int performance) {
		production = new ProductionItem(product,performance);
	}
}

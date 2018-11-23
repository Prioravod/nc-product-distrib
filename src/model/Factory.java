package model;

/** Factory producing 
 *  a certain type of product with 
 *  a certain performance
 */
public class Factory {
	private static int curr_id;
	public int id;
	public String factoryName;
	public ProductionItem production;
	
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
	
	public Factory(String factoryName,Product product,int performance) {
		this.id = curr_id++;
		this.factoryName = factoryName+id;
		this.production = new ProductionItem(product,performance);
	}

	public void setAnotherProduction(Product product,int performance) {
		production = new ProductionItem(product,performance);
	}
}

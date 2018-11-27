package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Shop with 
 *  location and 
 *  list of products sold
 */
public class Shop {
	private static int curr_id;
	public int id;
	public String shopName;
	public Geotag location;
	public List<CommodityItem> products;
	
	/** A commodity item stores in itself 
	 *  the type of goods, 
	 *  the quantity of goods in stock and 
	 *  the total quantity of goods of this type that can fit in a warehouse.
	 */
	public class CommodityItem {
		public Product item;
		public int allItemsCount = 100;
		public int currItemsCount;
		
		public CommodityItem(Product item, int currItemsCount) {
			this.item = item;
			this.currItemsCount = currItemsCount;
			//this.allItemsCount = currItemsCount;
		}	
		
		public CommodityItem(Product item, int allItemsCount, int currItemsCount) {
			this.item = item;
			this.allItemsCount = allItemsCount;
			this.currItemsCount = currItemsCount;
		}	
	}
	
	public Shop(String shopName, Geotag location) {
		this.id = curr_id++;
		this.shopName = shopName;
		this.location = location;
		this.products = new ArrayList<>();
	}
	public CommodityItem addCommodityItem(Product item, int currItemsCount) {
		return new CommodityItem(item, currItemsCount);
	}
	public CommodityItem addCommodityItem(Product item, int allItemsCount, int currItemsCount) {
		return new CommodityItem(item, allItemsCount, currItemsCount);
	}
}

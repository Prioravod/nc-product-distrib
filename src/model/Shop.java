package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/** Shop with 
 *  location and 
 *  list of products sold
 */
public class Shop{
	
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String shopName;
	@Getter @Setter private Geotag geotag;
	@Getter @Setter private List<CommodityItem> products;
	
	/** A commodity item stores in itself 
	 *  the type of goods, 
	 *  the quantity of goods in stock and 
	 *  the total quantity of goods of this type that can fit in a warehouse.
	 */
	public class CommodityItem{
		@Getter @Setter private Product item;
		@Getter @Setter private int allItemsCount = 100;
		@Getter @Setter private int currItemsCount;
		
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
		this.id = currId++;
		this.shopName = shopName;
		this.geotag = location;
		this.products = new ArrayList<>();
	}
	public CommodityItem addCommodityItem(Product item, int currItemsCount) {
		return new CommodityItem(item, currItemsCount);
	}
	public CommodityItem addCommodityItem(Product item, int allItemsCount, int currItemsCount) {
		return new CommodityItem(item, allItemsCount, currItemsCount);
	}
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Shop {
	private static int curr_id;
	public int id;
	public String shopName;
	public Geotag location;
	public List<CommodityItem> products;
	
	public class CommodityItem {
		public Product item;
		public int allItemsCount = 15;
		public int currItemsCount;
		
		public CommodityItem(Product item, int currItemsCount) {
			this.item = item;
			this.currItemsCount = currItemsCount;
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
	
	public void addItem(Product item, int currItemsCount) {
		Stream stream = products.stream().filter(x -> x.item.id == item.id);
		if (stream.count() == 0) {
			products.add(new CommodityItem(item, currItemsCount));
		}
		CommodityItem ci = (CommodityItem) stream.findFirst().get();
		ci.currItemsCount += currItemsCount;		
	}
	public List<Class<?>> buyItem(Class<?> cl, int needCount) {
		if (products.stream().filter(x -> x.getClass() == cl).count() == 0) return null;
		CommodityItem ci = products.stream().filter(x -> x.item.id == item.id).findFirst().get();
		ci.currItemsCount += currItemsCount;		
		
	}
	
}

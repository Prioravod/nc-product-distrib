package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
		Stream stream = products.stream().
				filter(x -> x.item.getClass() == item.getClass() && x.item.productName == item.productName);
		if (stream.count() == 0) {
			products.add(new CommodityItem(item, currItemsCount));
		}
		CommodityItem ci = (CommodityItem) stream.findFirst().get();
		ci.currItemsCount += currItemsCount;		
	}
//	public List<Product> buyItem(Class<?> cl, String name, int needCount) {
//		int loss = 0;
//		CommodityItem foundProduct = products.stream()
//				.filter(x -> x.item.getClass() == cl && x.item.productName == name)
//				.findFirst()
//				.get();
//		if (foundProduct.equals(null) && foundProduct.currItemsCount == 0) {
//			loss = needCount;
//			return null;
//		}
//		return products.stream().filter(x -> x.item.getClass() == cl).map(x -> x.item).collect(Collectors.toList());
//	}
	public List<Product> buyItem(Product item, int needCount){
		Stream stream = products.stream().
				filter(x -> x.item.getClass() == item.getClass() && x.item == item);
		if (stream.count() == 0) {
			return null;
		}
		CommodityItem ci = (CommodityItem) stream.findFirst().get();
		List<Product> lst = new ArrayList<>();
		for (int i=0;i<needCount && ci.currItemsCount > 0;i++) {
			ci.currItemsCount--;
			lst.add(ci.item);
		}
		return lst;
	}
	
}

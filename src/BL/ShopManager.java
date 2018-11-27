package BL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.*;
import model.Shop.CommodityItem;

public class ShopManager {
	
	private Shop shop;
	
	public ShopManager(String shopName, Geotag location){
		shop = new Shop(shopName, location);
	}
	public ShopManager(Shop shop){
		this.shop = shop;
	}
	public void addItem(Product item, int currItemsCount) {
		Optional<CommodityItem> ci = shop.products.stream().
				filter(x -> x.item.getClass() == item.getClass() && x.item.productName == item.productName).findFirst();
		if (ci.isPresent()) {
			ci.get().currItemsCount += currItemsCount;	
		}
		else shop.products.add(shop.addCommodityItem(item, currItemsCount));		
	}
	public List<Product> buyItem(Product item, int needCount){
		Stream<CommodityItem> stream = shop.products.stream().
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
	public void CheckWhatsNeed() {
		shop.products.stream()
			.filter(x->x.currItemsCount < x.allItemsCount)
			.map(x->new DemandManager(x.item,x.allItemsCount-x.currItemsCount,shop));
	}
	public List<Product> productList() {
		return shop.products.stream().map(x -> x.item).collect(Collectors.toList());
	}
	public List<String> productNameList() {
		return shop.products.stream().map(x -> x.item).map(x -> x.toString()).collect(Collectors.toList());
	}
	public int getProductCurrCount(Product product) {
		return shop.products.stream().filter(x -> x.item==product).findFirst().get().currItemsCount;
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
}

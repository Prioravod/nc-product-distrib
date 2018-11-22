package BL;
import java.util.ArrayList;
import java.util.List;

import model.*;
import model.Shop.CommodityItem;

public class ShopManager {
	
	Shop shop;
	
	public ShopManager(String shopName, Geotag location){
		shop = new Shop(shopName, location);
	}
	
//	public List<CommodityItem> getProducts() {
//		return shop.products;
//	}
//	public void setProducts(List<CommodityItem> products) {
//		if (products != null) shop.products = products;
//	}
//	public int getMissingProductsCount(Product item) {
//		int count = -1;
//		for (Shop.CommodityItem ci : products) {
//			if (ci.item == item) {
//				count = ci.allItemsCount - ci.currItemsCount;
//				break;
//			}
//		}
//		if (count==-1) return 0;
//		return count;
//	}
//
//	public void setImport(Product product, int count) {
//		//products.stream().filter(pr -> pr.item == product).forEach(ci -> ci.currItemsCount += count);
//		for (Shop.CommodityItem ci : products) {
//			if (ci.item == product) {
//				ci.currItemsCount += count;
//				return;
//			}
//		}
//		products.add(new CommodityItem(product,15,count));
//	}
//	
//	public List<Product> getProduct(Class<?> needProduct, int count) {
//		//products.stream().filter(pr -> pr.item.getClass() == needProduct).
//		for (CommodityItem pr: products ) {
//			if (pr.item.getClass()==needProduct && pr.currItemsCount>=count) {
//				pr.currItemsCount-=count;
//				List<Product> prodLst = new ArrayList<>();
//				for(int i=0;i<count;i++) prodLst.add(pr.item);
//				return prodLst;
//			}
//		}
//		//setDemand
//		return null;
//	}
}

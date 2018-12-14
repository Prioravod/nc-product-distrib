package controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;


import lombok.Getter;
import lombok.NonNull;
import interfaces.Visitable;
import model.*;
import model.Shop.CommodityItem;

public class ShopManager implements Visitable{
	
	@Getter @NonNull private Shop shop;
	
	public ShopManager(Shop shop){
		this.shop = shop;
	}
	public ShopManager(String shopName, Geotag location){
		this.shop = new Shop(shopName, location);
	}
	
	public void addItem(Product product, int currItemsCount) {
		Optional<CommodityItem> ci = shop.getProducts().stream().
				filter(x -> x.getItem().getClass() == product.getClass() && x.getItem().getProductName() == product.getProductName()).findFirst();
		if (ci.isPresent()) {
			int oldCurrItemsCount = ci.get().getCurrItemsCount();
			ci.get().setCurrItemsCount(oldCurrItemsCount + currItemsCount);	
		}
		else shop.getProducts().add(shop.addCommodityItem(product, currItemsCount));		
	}
	public List<Product> buyItem(Product item, int needCount){
		Optional<CommodityItem> ciOpt = shop.getProducts().stream().
				filter(x -> x.getItem().getClass() == item.getClass() && x.getItem() == item).findFirst();
		if (ciOpt.isPresent()) {
			CommodityItem ci = ciOpt.get();
			List<Product> lst = new ArrayList<>();
			for (int i=0;i<needCount && ci.getCurrItemsCount() > 0;i++) {
				int oldCurrItemsCount = ci.getCurrItemsCount();
				ci.setCurrItemsCount(oldCurrItemsCount-1);
				lst.add(ci.getItem());
			}
			return lst;
		}
		return null;
	}
	
	public void CheckWhatsNeed() {
//		shop.getProducts().stream()
//			.filter(x->x.getCurrItemsCount() < x.getAllItemsCount())
//			.map(x->new DemandManager(x.getItem(),x.getAllItemsCount()-x.getCurrItemsCount(),shop));
	}
	
	public List<Product> productList() {
		return shop.getProducts().stream().map(x -> x.getItem()).collect(Collectors.toList());
	}
	
	public List<String> productNameList() {
		return shop.getProducts().stream().map(x -> x.getItem()).map(x -> x.toString()).collect(Collectors.toList());
	}
	
	public int getProductCurrCount(Product product) {
		return shop.getProducts().stream().filter(x -> x.getItem()==product).findFirst().get().getCurrItemsCount();
	}
	
	
	@Override
	public Geotag getGeotag() {
		return shop.getGeotag();
	}
	@Override
	public void handlingCargo(Map<Product, Integer> map) {
		System.out.println("Coming:");
		for (Entry<Product, Integer> entry : map.entrySet()) {
	        System.out.println("Product =  " + entry.getKey() + " Count = " + entry.getValue());           
	    }
		
	}

	
}

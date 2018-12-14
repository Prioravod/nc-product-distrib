package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;
import lombok.NonNull;
import model.Company;
import model.Demand;
import model.Factory;
import model.Geotag;
import model.Product;
import model.Shop;

public class CompanyManager {
	@Getter private Company company;
	private FactoryManager factoryManager;
	private List<Factory> factories;
	
	public CompanyManager(@NonNull Company company) {
		this.company = company;
		this.factories = new ArrayList<>();
	}
	public void getDemand(Demand demand) {
//		for (Map.Entry<Product, Integer> entry : demand.getProducts().entrySet()) {
//			System.out.println(demand.getShop().getId() + " " + demand.getShop().getShopName());
//			System.out.println(entry.getKey() + " - " + entry.getValue());		
//		}
//		Optional<Factory> optFact = company.getFactories()
//				.stream()
//				.filter(fact -> fact.getProduction().item.equals(demand.getProductType())).findFirst();
//		
//		if (optFact.isPresent()) factoryManager = new FactoryManager(optFact.get());
//		else factoryManager = new FactoryManager(newFactory(demand.getProductType()));
//		
//		factoryManager.findTransportForDemand(demand);
	}

	private Factory newFactory(Product productType) {
		Factory factory = new Factory(company.getCompanyName(), productType, setFactoryLocation());
		factories.add(factory);		
		return factory;
	}
	private Geotag setFactoryLocation() {
		return null;		
	}
}

package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import dao.Static;
import lombok.NonNull;
import model.*;

public class DemandManager {
	
	private Demand demand;
	private Map<CompanyManager,Demand> cmMap = new HashMap<>();
	
	public DemandManager(@NonNull Demand demand) {
		this.demand = demand;
		distributeDemandByCompany();
	}
	public DemandManager(Map<Product,Integer> products,Shop shop) {
		this.demand = new Demand(products,shop);
		distributeDemandByCompany();
	}
	private void distributionFunction(Entry<Product, Integer> entry) {
		Company currCompany = entry.getKey().getCompany();
		Optional<Entry<CompanyManager, Demand>> optCM = cmMap.entrySet()
			.stream()
			.filter(cm -> cm.getKey().getCompany() == currCompany)
			.findFirst();
		if (optCM.isPresent()) {
			optCM.get().getValue().getProducts().put(entry.getKey(),entry.getValue());
		}
		else {
			CompanyManager newCMFromDemand = new CompanyManager(currCompany);
			Map<Product,Integer> newProducts = new HashMap<>();
			newProducts.put(entry.getKey(),entry.getValue());
			Demand newDemand = new Demand(newProducts,this.demand.getShop());
			cmMap.put(newCMFromDemand, newDemand);
		}
		
	}
	private void distributeDemandByCompany() {	
		System.out.println(demand.getShop().getShopName());
		for(Entry<Product, Integer> item : demand.getProducts().entrySet()){            
            System.out.println(item.getKey().getCompany().getCompanyName()+ " - " + 
            		item.getKey().getProductName() + " - " + item.getValue());            
        }
		demand.getProducts()
			  .entrySet()
			  .stream()
			  .forEach(Entry -> distributionFunction(Entry));	
		
	}
	public void printCurrCMMap() {
		cmMap.entrySet()
			.stream()
			.forEach(entry -> {
				System.out.println(entry.getKey().getCompany().getCompanyName());
				for (Entry<Product, Integer> x : entry.getValue().getProducts().entrySet()) {
					System.out.println(x.getKey() + " -> " + x.getValue());
				}
				System.out.println(entry.getValue().getShop().getShopName());
			});
		System.out.println();
	}
	
	private void sendDemand(CompanyManager companyManager, Demand newDemand) {
		companyManager.getDemand(newDemand);
	}
}



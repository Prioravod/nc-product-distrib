package controllers;

import model.*;

public class CompanyManager {
	private Company company;
	private FactoryManager factoryManager = new FactoryManager(company);
	
	public CompanyManager(Company company) {
		this.company = company;
	}

	public void getDemand(Demand demand) {
		if (company.getFactories().size()==0 || 
				company
				.getFactories().stream()
				.map(fact -> fact.getProduction().item == demand.getProductType()).findFirst() == null) {
				factoryManager.addNewFactory(demand.getProductType());;		
		}
	}

}

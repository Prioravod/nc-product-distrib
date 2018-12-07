package controllers;

import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.Demand;
import model.Factory;
import model.Geotag;
import model.Product;

public class CompanyManager {
	private Company company;
	private FactoryManager factoryManager;
	private List<Factory> factories;
	
	public CompanyManager(Company company) {
		this.company = company;
		this.factories = new ArrayList<>();
	}

	public void getDemand(Demand demand) {
		if (company.getFactories().size()==0 || 
				company
				.getFactories().stream()
				.map(fact -> fact.getProduction().item == demand.getProductType()).findFirst() == null) {
				addNewFactory(demand.getProductType());;		
		}
	}

	private void addNewFactory(Product productType) {
		Factory factory = new Factory(company.getCompanyName(), productType, setFactoryLocation());
		factories.add(factory);		
	}
	private Geotag setFactoryLocation() {
		return null;		
	}
}

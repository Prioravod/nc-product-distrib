package BL;

import model.*;

public class CompanyManager {
	private Company company;
	private int defaultPerformance = 15;
	private FactoryManager factoryManager = new FactoryManager(company);
	
	public CompanyManager(Company company) {
		this.company = company;
	}

	public void getDemand(Demand demand) {
		if (company.factories.size()==0 || 
				company
				.factories.stream()
				.map(fact -> fact.production.item == demand.productType).findFirst() == null) {
				factoryManager.addNewFactory(demand.productType,defaultPerformance);;		
		}
	}

}

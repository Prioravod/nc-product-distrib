package controllers;

import dao.Static;
import model.*;

public class DemandManager {
	private Demand demand;
	private CompanyManager companyManager;
	public DemandManager(Product productType, int count,Shop shop) {
		this.demand = new Demand(productType, count,shop);
		sendDemand();
	}
	private void sendDemand() {
		if (companyManager == null) {
			Company company = Static.companyBase.stream().filter(x -> x == demand.getProductType().getCompany()).findFirst().get();
			companyManager = new CompanyManager(company);
		}
		companyManager.getDemand(demand);
		
	}

}

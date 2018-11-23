package BL;

import java.util.*;

import model.*;

public class FactoryManager {
	private List<Factory> factory = new ArrayList<>();
	private Company company;

	public FactoryManager(Company company) {
		this.company = company;
	}
	public void addNewFactory(Product item,int performance) {
		factory.add(new Factory(company.companyName,item,performance));
	}
	

}
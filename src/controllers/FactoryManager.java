package controllers;

import java.util.*;

import model.*;

public class FactoryManager {
	private List<Factory> factories = new ArrayList<>();
	private List<Transport> transport = new ArrayList<>();
	private Company company;

	public FactoryManager(Company company) {
		this.company = company;
	}
	public void addNewFactory(Product item) {
		factories.add(new Factory(company.getCompanyName(),item));
	}
	public void buyNewVehicle(Factory factory) {
		transport.add(new Transport("x999xx64", TransportType.ROADTRAIN, factory));
	}

}

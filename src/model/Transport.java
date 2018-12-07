package model;

import java.util.HashMap;
import java.util.Map;

import controllers.FactoryManager;
import interfaces.Visitable;
import lombok.Getter;
import lombok.Setter;

public class Transport{
	
	@Getter @Setter private String brand;
	@Getter @Setter private String model;
	@Getter private String stateNumber;
	@Getter private TransportType type;
	@Getter @Setter private Factory ownerFactory;
	@Getter @Setter private Visitable currentVisitablePlace;
	@Getter @Setter private Map<Visitable,Map<Product,Integer>> routeList;
	@Getter @Setter private boolean transit = false;
	
	
	public Transport(String stateNumber, TransportType type, FactoryManager factoryManager) {
		this.stateNumber = stateNumber;
		this.type = type;
		this.ownerFactory = factoryManager.getFactory();
		this.currentVisitablePlace = factoryManager;
		this.routeList = new HashMap<>();
	}


	@Override
	public String toString() {
		return this.type.name() + " (" + this.stateNumber + ") owner: " + this.ownerFactory.getFactoryName() + 
				" load: " + routeList.isEmpty() + " in transit: " + this.transit;
	}
	
	
}

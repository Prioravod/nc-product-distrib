package controllers;

import java.util.*;

import interfaces.Visitable;
import lombok.Getter;
import lombok.NonNull;
import model.*;

public class FactoryManager implements Visitable{
	@Getter @NonNull private Factory factory;
	
	public FactoryManager(@NonNull Factory factory) {
		this.factory = factory;
	}	
	
	public FactoryManager(String factoryName,Product product,Geotag geotag) {
		this.factory = new Factory(factoryName,product,geotag);
	}
	
	public void buyNewVehicle(String stateNumber, TransportType transportType, FactoryManager factoryManager) {
		factory.getTransportList().add(new Transport(stateNumber,transportType, factoryManager));
	}
	
	public void findTransportForDemand(Demand demand) {
		factory.getTransportList().stream().filter(x -> x.isTransit() == false).findFirst().ifPresent(x -> setDemand(x, demand));		
	}
	
	private final void setDemand(Transport transport, Demand demand) {
		TransportManager tm = new TransportManager(transport);
		ShopManager sm = new ShopManager(demand.getShop());
		tm.addNewCargoToRoutePoint(sm,demand.getProducts());
	}
	
	@Override
	public Geotag getGeotag() {
		return factory.getGeotag();
	}
	
	@Override
	public void handlingCargo(Map<Product, Integer> map) {
		// TODO Auto-generated method stub
		
	}

	
	

}

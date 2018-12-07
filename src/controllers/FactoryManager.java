package controllers;

import java.util.*;

import interfaces.Visitable;
import lombok.Getter;
import lombok.NonNull;
import model.*;

public class FactoryManager implements Visitable{
	@Getter @NonNull private Factory factory;
	
	public FactoryManager(String factoryName,Product product,Geotag geotag) {
		this.factory = new Factory(factoryName,product,geotag);
	}
	public void buyNewVehicle() {
		factory.getTransportList().add(new Transport("x999xx64", TransportType.ROADTRAIN, this));
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

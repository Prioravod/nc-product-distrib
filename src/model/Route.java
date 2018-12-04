package model;

import interfaces.Visitable;
import lombok.Getter;
import lombok.Setter;

public class Route {
	
	@Getter @Setter private Visitable start;
	@Getter @Setter private Visitable end;
	@Getter @Setter private Class<Product> cargoType;
	@Getter @Setter private int cargoCount;
	
	public Route(Visitable currentLocation, Visitable targetLocation, Class<Product> cargoType, int cargoCount) {
		this.start = currentLocation;
		this.end = targetLocation;
		this.cargoType = cargoType;
		this.cargoCount = cargoCount;
	}
}

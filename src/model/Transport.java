package model;

import java.util.List;

import interfaces.Visitable;
import lombok.Getter;
import lombok.Setter;
import model.Shop.CommodityItem;

public class Transport {
	
	@Getter @Setter private String brand;
	@Getter @Setter private String model;
	@Getter private String stateNumber;
	@Getter private TransportType type;
	@Getter @Setter private Factory ownerFactory;
	@Getter @Setter private Visitable currentVisitablePlace;
	@Getter @Setter private List<Route> routeList;
	@Getter @Setter private List<Cargo> cargo;
	
	
	public Transport(String stateNumber, TransportType type, Factory factory) {
		this.stateNumber = stateNumber;
		this.type = type;
		this.ownerFactory = factory;
		this.currentVisitablePlace = factory;
	}
	public class Cargo{
		@Getter @Setter private Class<Product> cargoType;		
		@Getter @Setter private int cargoCount;
		
		public Cargo(Class<Product> cargoType, int cargoCount) {
			this.cargoType = cargoType;
			this.cargoCount = cargoCount;
		}
	}
	public Cargo addCargo(Class<Product> cargoType, int cargoCount) {
		return new Cargo(cargoType, cargoCount);
	}
}

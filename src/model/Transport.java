package model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Transport {
	
	@Getter @Setter private String brand;
	@Getter @Setter private String model;
	@Getter private String stateNumber;
	@Getter private TransportType type;
	@Getter @Setter private List<Route> routeList;
	
	
	Transport(String stateNumber, TransportType type) {
		this.stateNumber = stateNumber;
		this.type = type;
	}
	
	Transport(String brand, String model, String stateNumber, TransportType type) {
		this.brand = brand;
		this.model = model;
		this.stateNumber = stateNumber;
		this.type = type;
	}
	
}

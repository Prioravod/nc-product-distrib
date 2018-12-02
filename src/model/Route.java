package model;

import lombok.Getter;
import lombok.Setter;

public class Route {
	
	@Getter @Setter private Geotag start;
	@Getter @Setter private Geotag end;
	@Getter @Setter private Class<Product> cargoType;
	@Getter @Setter private int cargoCount;
	
	public Route(Geotag start, Geotag end, Class<Product> cargoType, int cargoCount) {
		this.start = start;
		this.end = end;
		this.cargoType = cargoType;
		this.cargoCount = cargoCount;
	}
}

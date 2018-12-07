package model;

import interfaces.Truckable;
import lombok.Getter;

public enum TransportType implements Truckable{
	RAILTRAIN{
		@Getter int commercialSpeed = 10;
		@Getter int capacity = 500;
		@Getter long mileageCost = 50;
	}, 
	ROADTRAIN{
		@Getter int commercialSpeed = 50;
		@Getter int capacity = 200;
		@Getter long mileageCost = 1000;
	}, 
	AIRCRAFT{
		@Getter int commercialSpeed = 700;
		@Getter int capacity = 50;
		@Getter long mileageCost = 10000;
	};
}

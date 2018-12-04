package model;

import interfaces.Truckable;
import lombok.Getter;

public enum TransportType implements Truckable{
	RAILTRAIN{
		@Getter int commercialSpeed = 10;
		@Getter int capacity = 400;
		@Getter long mileageCost = 2000;
	}, 
	ROADTRAIN{
		@Getter int commercialSpeed = 50;
		@Getter int capacity = 200;
		@Getter long mileageCost = 3000;
	}, 
	AIRCRAFT{
		@Getter int commercialSpeed = 600;
		@Getter int capacity = 50;
		@Getter long mileageCost = 10000;
	};
}

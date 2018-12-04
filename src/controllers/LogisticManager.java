package controllers;

import java.util.List;
import java.util.Optional;

import interfaces.Truckable;
import interfaces.Visitable;
import lombok.Getter;
import lombok.Setter;
import model.Geotag;
import model.Product;
import model.Route;
import model.Shop;
import model.Transport;
import model.Transport.Cargo;
import model.TransportType;

public class LogisticManager {
	@Getter @Setter private Transport transport;
	@Getter @Setter private Truckable trucks;
	@Getter @Setter private ShopManager sm;
	
	
	public void setNewRoutePoint(Visitable target, Class<Product> cargoType, int count) {
		Visitable now = transport.getCurrentVisitablePlace();
		Route route = new Route(now, target, cargoType, count);
		List<Route> routelist = transport.getRouteList();
		routelist.add(route);
		transport.setRouteList(routelist);
		System.out.println(calculateTripCost(now,target,transport.getType()));
	}
	
	public void addCargo(Class<Product> cargoType, int cargoCount) {
		Optional<Cargo> opt = transport.getCargo().stream().filter(x -> x.getCargoType() == cargoType).findFirst();
		if (opt.isPresent()) {
			int oldCount = opt.get().getCargoCount();
			opt.get().setCargoCount(oldCount + cargoCount);
		}
		else {
			transport.getCargo().add(transport.addCargo(cargoType, cargoCount));		
		}		
	}
	
	public void unloadCargo(Shop shop) {
		//transfr products to the store in accordance with routelist
//		sm = new ShopManager(shop);
//		sm.acceptCargo(transport.getCargo(). productType, count);
	}
	
	public void removeLastPoint() {		
		transport.getRouteList().remove(transport.getRouteList().size()-1);
	}
	
	public long calculateTripCost(Visitable now,Visitable target, TransportType type) {
		long roundedDistance = Math.round(getVector(now,target));
		long mileageCost = type.getMileageCost();
		return roundedDistance * mileageCost;
		
	}
	
	public double getVector(Visitable now, Visitable target) {
		Geotag gt1 = now.getGeotag();
		Geotag gt2 = target.getGeotag();		
		return getVector(gt1,gt2);
	}
	public double getVector(Geotag gt1, Geotag gt2) {
		double lat1Rad = gt1.getLatitude() * Math.PI / 180;
		double lat2Rad = gt2.getLatitude() * Math.PI / 180;
		double long1Rad = gt1.getLatitude() * Math.PI / 180;
		double long2Rad = gt2.getLongitude() * Math.PI / 180;
		return Math.acos(
				Math.sin(lat1Rad) * Math.sin(lat2Rad) +
				Math.cos(lat1Rad) * Math.cos(lat2Rad) *
				Math.cos(long1Rad - long2Rad)				
				)*6371;
	}

}

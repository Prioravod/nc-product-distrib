package controllers;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import interfaces.Visitable;
import lombok.NonNull;
import model.Geotag;
import model.Product;
import model.Transport;

public class TransportManager {
	
	private Transport transport;
	
	public TransportManager(@NonNull Transport transport) {
		this.transport = transport;
	}

	public void addNewCargoToRoutePoint(Visitable target, Map<Product,Integer> cargo) {
		Map<Visitable,Map<Product,Integer>> routeList = transport.getRouteList();
		Map<Product,Integer> optionalOldCargo = routeList.get(target);
		if (optionalOldCargo == null) {
			routeList.put(target, cargo);
		}
		else {			
			routeList.put(target, sumCargoes(optionalOldCargo,cargo));
		}
		transport.setRouteList(routeList);
	}
	
	public Entry<Visitable, Map<Product, Integer>> findNearestPoint() {
		Map<Visitable,Map<Product,Integer>> routeList = transport.getRouteList();
		final Visitable now = transport.getCurrentVisitablePlace();
		Optional<Entry<Visitable, Map<Product, Integer>>> nearest = routeList.entrySet().stream().min((x1,x2)->Double.compare(getVector(now,x1.getKey()),getVector(now,x2.getKey())));
		if (nearest.isPresent()) {
			return nearest.get();
		}
		return null;
		
	}
	
	public void tripToPoint(Visitable target) throws InterruptedException {
		Visitable now = transport.getCurrentVisitablePlace();
		long timeInHours = calculateTripTime(now,target);
		transport.setTransit(true);
		System.out.println(transport.toString());
		long syntheticTimeInSeconds = timeInHours; 
		System.out.println("--- In progress ---");
		Thread.sleep(syntheticTimeInSeconds * 1000);
		System.out.println("--- " + transport.getType().name() + " has arrived ---");
		arrival(target);
	}
	
	public void arrival(Visitable now) {
		transport.setTransit(false);
		transport.setCurrentVisitablePlace(now);
		Map<Product,Integer> cargo = getCargo(now);
		now.handlingCargo(cargo);
		transport.getRouteList().remove(now);
	}

	private Map<Product,Integer> sumCargoes(Map<Product,Integer> cargoOld, Map<Product,Integer> cargoNew) {
		Map<Product,Integer> newMap = Stream.of(cargoOld,cargoNew)
				.map(Map::entrySet)
				.flatMap(Collection::stream)
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						Integer::sum
						));
		return newMap;
	}
	
	
	private Map<Product,Integer> getCargo(Visitable v) {
		Map<Product,Integer> cargo = transport.getRouteList().get(v);
		transport.getRouteList().remove(v);
		return cargo;
	}
		
	
	public void removePoint(Visitable v) {		
		transport.getRouteList().remove(v);
	}
	
	public long calculateTripCost(Visitable now,Visitable target) {
		long roundedDistance = Math.round(getVector(now,target));
		long mileageCost = transport.getType().getMileageCost();
		return roundedDistance * mileageCost;		
	}
	
	public long calculateTripTime(Visitable now,Visitable target) {
		long roundedDistance = Math.round(getVector(now,target));
		int speed = transport.getType().getCommercialSpeed();
		return speed*roundedDistance;
		
	}
	
	public double getVector(Visitable now, Visitable target) {
		Geotag gt1 = now.getGeotag();
		Geotag gt2 = target.getGeotag();		
		return getVector(gt1,gt2);
	}
	public final double getVector(Geotag gt1, Geotag gt2) {
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


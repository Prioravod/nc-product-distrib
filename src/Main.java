import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;

public class Main {

	public static void main(String[] args) {
//		List<Product> lst = new ArrayList<>();
//		lst.add(new Juice("Dobryi",1.5f));
//		lst.add(new Juice("Ya",1f));
//		lst.add(new Nuts("Greece",1f));
//		lst.add(new Juice("My family",2f));
//		System.out.println("Assortment:");
//		lst.stream().forEach(System.out::println);
		
//		double d = CalculateTransfer.getVector(new Geotag("kremlin",55.750968d,37.617156d), new Geotag("myhouse",51.602973d,45.978380d));
//		System.out.println(d);
		Map<Integer,Integer> innerMap1 = new HashMap<>();
		innerMap1.put(1, 10);
		innerMap1.put(5, 10);
		System.out.println(innerMap1.get(40));
		innerMap1.put(40, 10);
		System.out.println(innerMap1.get(40));
//		Map<Integer,Integer> innerMap2 = new HashMap<>();
//		innerMap2.put(2, 20);
//		innerMap2.put(6, 20);
//		innerMap2.put(10, 20);
//		innerMap2.put(5, 20);
//		Map<Integer,Integer> newMap = Stream.of(innerMap1,innerMap2)
//				.map(Map::entrySet)
//				.flatMap(Collection::stream)
//				.collect(Collectors.toMap(
//						Map.Entry::getKey,
//						Map.Entry::getValue,
//						Integer::sum
//						));
//		System.out.println(newMap);
		Human h1 = new Human("q");
		System.out.println(h1.getLst());
		h1.getLst().add(3);
		h1.getLst().add(4);
		System.out.println(h1.getLst());
		h1.getLst().remove((Integer)3);
		System.out.println(h1.getLst());
		
	}

}
class Human{
	String name;
	public Human(String name) {
		this.name = name;
		lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
	}
	@Getter @Setter private List<Integer> lst;
	
	
}
abstract class Product{
	private static int curr_id = 0; 
	public int id;
	Product() {
		this.id = curr_id++;
	}
}
class Juice extends Product{
	public String name;
	public float volume;
	Juice(String name, float volume){
		this.name = name;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return this.getClass()+" - "+ name + " " + volume + " litres (id" + id + ")";		
	}
}
class Nuts extends Product{
	public String type;
	public float weight;	
	Nuts(String type, float weight) {
		this.type = type;
		this.weight = weight;
	}	@Override
	public String toString() {
		return this.getClass()+" - " + type+" nuts "+weight+" kg (id" + id + ")";		
	}
}

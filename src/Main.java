import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;
import model.Company;
import model.Juice;
import model.Product;

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
//		Map<Integer,Integer> innerMap1 = new HashMap<>();
//		innerMap1.put(1, 10);
//		innerMap1.put(5, 10);
//		System.out.println(innerMap1.get(40));
//		innerMap1.put(40, 10);
//		System.out.println(innerMap1.get(40));
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
//		Human h1 = new Human("q");
//		System.out.println(h1.getLst());
//		h1.getLst().add(3);
//		h1.getLst().add(4);
//		System.out.println(h1.getLst());
//		h1.getLst().remove((Integer)3);
//		System.out.println(h1.getLst());
		
//	    List<Entity> lst = new ArrayList<>();
//	    lst.add(new Entity("name1", "company1", 5));
//	    lst.add(new Entity("name2", "company1", 2));
//	    lst.add(new Entity("name1", "company2", 3));
//	    lst.add(new Entity("name1", "company3", 1));
//	    lst.add(new Entity("name3", "company1", 4));
//	    lst.add(new Entity("name2", "company2", 6));
//	    lst.add(new Entity("name2", "company3", 0));	    
//	    Map<String, List<Entity>> entityMap = lst.stream().collect(Collectors.groupingBy(Entity::getCompany));
//	    for(Map.Entry<String, List<Entity>> item : entityMap.entrySet()){
//            
//            System.out.println(item.getKey());
//            for(Entity entity : item.getValue()){
//                  
//                System.out.println(entity.getName() + " - " + entity.getCount() + " pcs.");
//            }
//            System.out.println();
//	    }
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

class Entity {
	@Getter private String name;
	@Getter private String company;
	@Getter private Integer count;
	public Entity(String name, String company, Integer count) {
		super();
		this.name = name;
		this.company = company;
		this.count = count;
	}
}
//abstract class Product{
//	private static int curr_id = 0; 
//	public int id;
//	Product() {
//		this.id = curr_id++;
//	}
//}
//class Juice extends Product{
//	public String name;
//	public float volume;
//	Juice(String name, float volume){
//		this.name = name;
//		this.volume = volume;
//	}
//	@Override
//	public String toString() {
//		return this.getClass()+" - "+ name + " " + volume + " litres (id" + id + ")";		
//	}
//}
//class Nuts extends Product{
//	public String type;
//	public float weight;	
//	Nuts(String type, float weight) {
//		this.type = type;
//		this.weight = weight;
//	}	@Override
//	public String toString() {
//		return this.getClass()+" - " + type+" nuts "+weight+" kg (id" + id + ")";		
//	}
//}

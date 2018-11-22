import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {


		List<Product> lst = new ArrayList<>();
		lst.add(new Juice("Dobryi",1.5f));
		lst.add(new Juice("Ya",1f));
		lst.add(new Nuts("Greece",1f));
		lst.add(new Juice("My family",2f));
		System.out.println("Assortment:");
		lst.stream().forEach(System.out::println);
		
		

	}

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

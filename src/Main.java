import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {


		List<X> lst = new ArrayList<>();
		X x1 = new Y();
		X x2 = new X();
		lst.add(x1);
		lst.add(x2);
		System.out.println(lst.get(0).getClass());
		System.out.println(lst.get(1).getClass());	
		
		

	}

}
class X{
	
}
class Y extends X{
	
}

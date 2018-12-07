package interfaces;

import java.util.Map;

import model.Geotag;
import model.Product;

public interface Visitable {
	Geotag getGeotag();
	void handlingCargo(Map<Product,Integer> map);
}

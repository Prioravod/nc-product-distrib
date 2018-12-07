package dao;

import java.util.ArrayList;
import java.util.List;

import controllers.*;
import model.*;

public class Static {
	public static List<Shop> shopBase = new ArrayList<>();
	public static List<Company> companyBase = new ArrayList<>();
	
	static {
		Shop pc = new Shop("Pyatorochka-Chemodurova", new Geotag("Chemodurova,14",51.607446d, 45.975488d));
		Shop pt = new Shop("Pyatorochka-Tarhova", new Geotag("Tarhova,14",51.610580d, 45.982037d));
		Shop mlk = new Shop("Magnit-Leb.Kumacha", new Geotag("Lebedeva-Kumacha,71a, 71À",51.610048d, 45.977416d));
		Company dobrii = new Company("Dobrii");
		Company ya = new Company("Ya");
		Product jdo = new Juice(dobrii, "OrangeJuice", 70l, 2000);
		Product jda = new Juice(dobrii, "AppleJuice", 60l, 2000);
		Product jyp = new Juice(ya, "PineappleJuice", 100l, 1000);
		ShopManager sm = new ShopManager(pc);
		sm.addItem(jdo, 10);
		sm.addItem(jda, 15);

		sm = new ShopManager(pt);
		sm.addItem(jdo, 5);
		sm.addItem(jda, 20);
		
		sm = new ShopManager(mlk);
		sm.addItem(jdo, 3);
		sm.addItem(jda, 8);
		sm.addItem(jyp, 10);
		
		shopBase.add(pc);
		shopBase.add(pt);
		shopBase.add(mlk);
		
		companyBase.add(dobrii);
		companyBase.add(ya);
		
	}
	
	
}

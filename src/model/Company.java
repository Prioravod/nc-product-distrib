package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company{
	private static int curr_id;
	private int id;
	private String companyName;
	private LocalDateTime foundingDate;
	private Geotag headquarter;
	private List<Human> founders;
	private Human ceo;
	private List<Factory> factories;
	
	public Company(int id, String companyName) {
		this.id = curr_id++;
		this.companyName = companyName;
		this.factories = new ArrayList<>();
		this.factories.add(new Factory(companyName));
	}

	public Company(int id, String companyName, LocalDateTime foundingDate, Geotag headquarter, Human ceo) {
		this.id = curr_id++;
		this.companyName = companyName;
		this.foundingDate = foundingDate;
		this.headquarter = headquarter;
		this.ceo = ceo;
	}

	public void getDemand(Demand demand) {
		
	}
	
}

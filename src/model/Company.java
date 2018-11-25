package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/** Company that stores information 
 *  about its factories and 
 *  accepts demands from stores 
 */
public class Company{
	private static int curr_id;
	public int id;
	public String companyName;
	public LocalDateTime foundingDate;
	public Geotag headquarter;
	public List<Human> founders;
	public Human ceo;
	public List<Factory> factories = new ArrayList<>();;
	
	public Company(int id, String companyName) {
		this.id = curr_id++;
		this.companyName = companyName;
	}

	public Company(int id, String companyName, LocalDateTime foundingDate, Geotag headquarter, Human ceo) {
		this.id = curr_id++;
		this.companyName = companyName;
		this.foundingDate = foundingDate;
		this.headquarter = headquarter;
		this.ceo = ceo;
	}
}

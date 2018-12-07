package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/** Company that stores information 
 *  about its factories and 
 *  accepts demands from stores 
 */
public class Company{
	
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String companyName;
	@Getter @Setter private List<Factory> factories = new ArrayList<>();;
	
	public Company(String companyName) {
		this.id = currId++;
		this.companyName = companyName;
	}
}

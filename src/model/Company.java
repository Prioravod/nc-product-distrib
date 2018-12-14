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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyName != other.companyName)
			return false;
		return true;
	}
	
	
}

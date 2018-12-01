package model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/** Human who has 
 *  full name and 
 *  date of birth
 */
public class Human {
	private static int currId;
	@Getter private int id;
	@Getter @Setter private String firstName;
	@Getter @Setter private String surName;
	@Getter @Setter private String patronymic;
	@Getter @Setter private LocalDateTime borningDate;
	
	public Human(String firstName) {
		this.id = currId++;
		this.firstName = firstName;
	}
	
	public Human(String firstName, String surName) {
		this.id = currId++;
		this.firstName = firstName;
		this.surName = surName;
	}

	public Human(String firstName, String surName, String patronymic, LocalDateTime borningDate) {
		this.id = currId++;
		this.firstName = firstName;
		this.surName = surName;
		this.patronymic = patronymic;
		this.borningDate = borningDate;
	}
	
	
}

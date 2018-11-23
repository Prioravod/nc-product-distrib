package model;

import java.time.LocalDateTime;

/** Human who has 
 *  full name and 
 *  date of birth
 */
public class Human {
	private static int curr_id;
	public int id;
	public String firstName;
	public String surName;
	public String patronymic;
	public LocalDateTime borningDate;
	
	public Human(String firstName) {
		this.id = curr_id++;
		this.firstName = firstName;
	}
	
	public Human(String firstName, String surName) {
		this.id = curr_id++;
		this.firstName = firstName;
		this.surName = surName;
	}

	public Human(String firstName, String surName, String patronymic, LocalDateTime borningDate) {
		this.id = curr_id++;
		this.firstName = firstName;
		this.surName = surName;
		this.patronymic = patronymic;
		this.borningDate = borningDate;
	}
	
	
}

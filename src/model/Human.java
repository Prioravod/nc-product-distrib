package model;

import java.time.LocalDateTime;

public class Human {
	private static int curr_id;
	private int id;
	private String firstName;
	private String surName;
	private String patronymic;
	private LocalDateTime borningDate;
	
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

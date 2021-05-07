package Entities;

import Abstract.Entity;

public class Gamer implements Entity {
	
	private int id;
	private String name;
	private String surname;
	private long nationalId;
	private int dateOfBirth;
	
	
	public Gamer(int id, String name, String surname, long nationalId, int dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.nationalId = nationalId;
		this.dateOfBirth = dateOfBirth;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getNationalId() {
		return nationalId;
	}
	public void setNationalId(long nationalId) {
		this.nationalId = nationalId;
	}
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}

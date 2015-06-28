package org.gradle;

import java.util.UUID;

public class Information {
	private String firstName;
	private String middleName;
	private String lastName;
	private String years;
	private String placeOfBirth;
	private String currentAddress;
	private String placeOfDeath;
	private String id;

	public Information() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setYearsOfLife(String yearsOfLife) {
		this.years = yearsOfLife;
	}

	public String getYearsOfLife() {
		return years;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setPlaceOfDeath(String placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}

	public String getPlaceOfDeath() {
		return placeOfDeath;
	}
}

package org.gradle;

import java.util.UUID;

public class Information {
	private String id;
	private String lastName;
	private String firstName;
	private String middleName;
	private String dateOfBirth;
	private String placeOfBirth;
	private String currentAddress;
	private String dateOfDeath;
	private String placeOfDeath;

	public Information() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
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

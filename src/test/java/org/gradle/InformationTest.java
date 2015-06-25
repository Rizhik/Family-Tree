package org.gradle;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class InformationTest {

	@Test
	public void getCurrentAddress() {
		Information information = new Information();
		information.setCurrentAddress("Seattle street");
		String result = information.getCurrentAddress();
		AssertJUnit.assertEquals("Seattle street", result);
	}

	@Test
	public void getFirstName() {
		Information information = new Information();
		information.setFirstName("FirstName");
		String result = information.getFirstName();
		AssertJUnit.assertEquals("FirstName", result);
	}

	@Test
	public void getLastName() {
		Information information = new Information();
		information.setLastName("LastName");
		String result = information.getLastName();
		AssertJUnit.assertEquals("LastName", result);
	}

	@Test
	public void getMiddleName() {
		Information information = new Information();
		information.setMiddleName("MiddleName");
		String result = information.getMiddleName();
		AssertJUnit.assertEquals("MiddleName", result);
	}

	@Test
	public void getPlaceOfBirth() {
		Information information = new Information();
		information.setPlaceOfBirth("Kharkiv");
		String result = information.getPlaceOfBirth();
		AssertJUnit.assertEquals("Kharkiv", result);
	}

	@Test
	public void getPlaceOfDeath() {
		Information information = new Information();
		information.setPlaceOfDeath("Moscow");
		String result = information.getPlaceOfDeath();
		AssertJUnit.assertEquals("Moscow", result);
	}

	@Test(enabled = false)
	public void getYearsOfLife() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void setCurrentAddress() {
		Information information = new Information();
		information.setCurrentAddress("CurrentAddress");
		AssertJUnit.assertEquals("CurrentAddress", information.getCurrentAddress());
	}

	@Test
	public void setFirstName() {
		Information information = new Information();
		information.setFirstName("FirstName");
		AssertJUnit.assertEquals("FirstName", information.getFirstName());
	}

	@Test
	public void setLastName() {
		Information information = new Information();
		information.setLastName("LastName");
		AssertJUnit.assertEquals("LastName", information.getLastName());
	}

	@Test
	public void setMiddleName() {
		Information information = new Information();
		information.setMiddleName("MiddleName");
		AssertJUnit.assertEquals("MiddleName", information.getMiddleName());
	}

	@Test
	public void setPlaceOfBirth() {
		Information information = new Information();
		information.setPlaceOfBirth("Vladivostok");
		AssertJUnit.assertEquals("Vladivostok", information.getPlaceOfBirth());
	}

	@Test
	public void setPlaceOfDeath() {
		Information information = new Information();
		information.setPlaceOfDeath("Minsk");
		AssertJUnit.assertEquals("Minsk", information.getPlaceOfDeath());
	}

	@Test(enabled = false)
	public void setYearsOfLife() {
		throw new RuntimeException("Test not implemented");
	}
}

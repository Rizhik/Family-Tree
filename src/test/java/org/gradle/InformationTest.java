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

	@Test
	public void getDateOfBirth() {
		Information information = new Information();
		information.setDateOfBirth("24-11-1945");
		String result = information.getDateOfBirth();
		AssertJUnit.assertEquals("24-11-1945", result);
	}

	@Test
	public void getDateOfDeath() {
		Information information = new Information();
		information.setDateOfDeath("24-11-1948");
		String result = information.getDateOfDeath();
		AssertJUnit.assertEquals("24-11-1948", result);
	}

	@Test
	public void getId() {
		Information information = new Information();
		AssertJUnit.assertNotNull(information.getId());
	}

	@Test
	public void setId() {
		Information information = new Information();
		information.setId("1234567890");
		AssertJUnit.assertEquals("1234567890", information.getId());
	}

	@Test
	public void setDateOfDeath() {
		Information information = new Information();
		information.setDateOfDeath("7-03-1964");
		AssertJUnit.assertEquals("7-03-1964", information.getDateOfDeath());
	}

	@Test
	public void setDateOfBirth() {
		Information information = new Information();
		information.setDateOfBirth("17-04-1976");
		AssertJUnit.assertEquals("17-04-1976", information.getDateOfBirth());
	}

	@Test
	public void setCurrentAddress() {
		Information information = new Information();
		information.setCurrentAddress("CurrentAddress");
		AssertJUnit.assertEquals("CurrentAddress",
				information.getCurrentAddress());
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

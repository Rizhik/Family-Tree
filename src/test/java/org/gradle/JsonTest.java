package org.gradle;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void loadAllRecords() {
		Information information = Json.loadAllRecords(mapper,
				"c80eeb1f-0372-4317-a23c-f152a2b3e3bf", "./src/test/resources/org/gradle/");
		AssertJUnit.assertEquals("Ivanova", information.getLastName());
		AssertJUnit.assertEquals("Irina", information.getFirstName());
		AssertJUnit.assertEquals("Vasilievna", information.getMiddleName());
		AssertJUnit.assertEquals("17-7-1954", information.getDateOfBirth());
		AssertJUnit.assertEquals("Kharkiv", information.getPlaceOfBirth());
		AssertJUnit.assertEquals("Kirkland", information.getCurrentAddress());
		AssertJUnit.assertEquals("29-8-2011", information.getDateOfDeath());
		AssertJUnit.assertEquals("Riga", information.getPlaceOfDeath());
		AssertJUnit.assertNotNull(information.getId());
	}

	@Test
	public void saveRecords() {

		Information info_init = new Information();
		info_init.setFirstName("Alex");
		info_init.setMiddleName("Ivan");
		info_init.setLastName("Samuel");
		info_init.setPlaceOfBirth("New York");
		info_init.setPlaceOfDeath("Chicago");
		info_init.setDateOfBirth("17-7-1954");
		info_init.setDateOfDeath("29-8-2011");

		Json.saveRecords(mapper, info_init, "JsonTest_SaveRecords",
				"./src/test/resources/org/gradle/");

		Information info_result = new Information();
		String info_result_ID = info_result.getId();
		info_result = Json.loadAllRecords(mapper,
				"JsonTest_SaveRecords","./src/test/resources/org/gradle/");

		AssertJUnit.assertEquals(info_init.getLastName(),
				info_result.getLastName());
		AssertJUnit.assertEquals(info_init.getFirstName(),
				info_result.getFirstName());
		AssertJUnit.assertEquals(info_init.getMiddleName(),
				info_result.getMiddleName());
		AssertJUnit.assertEquals(info_init.getDateOfBirth(),
				info_result.getDateOfBirth());
		AssertJUnit.assertEquals(info_init.getDateOfDeath(),
				info_result.getDateOfDeath());
		AssertJUnit.assertEquals(info_init.getPlaceOfBirth(),
				info_result.getPlaceOfBirth());
		AssertJUnit.assertEquals(info_init.getPlaceOfDeath(),
				info_result.getPlaceOfDeath());
		AssertJUnit.assertEquals(info_init.getCurrentAddress(),
				info_result.getCurrentAddress());
		AssertJUnit.assertFalse(info_result_ID.equals(info_result.getId()));
	}
}

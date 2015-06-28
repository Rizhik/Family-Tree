package org.gradle;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	ObjectMapper mapper = new ObjectMapper();

	@Test//TODO update the test
	public void loadAllRecords() {
		Json json = new Json();
		Information information = Json.loadAllRecords(mapper,
				"./src/test/resources/org/gradle/JsonTest_LoadAllRecords.txt");
		AssertJUnit.assertEquals("Perova", information.getLastName());
		AssertJUnit.assertEquals("Anna", information.getFirstName());
		AssertJUnit.assertEquals("Igorevna", information.getMiddleName());
		AssertJUnit.assertNull(information.getYearsOfLife());
		AssertJUnit.assertEquals("Kharkiv", information.getPlaceOfBirth());
		AssertJUnit.assertNull(information.getPlaceOfDeath());
		AssertJUnit.assertEquals("Kirkland", information.getCurrentAddress());
	}

	@Test
	public void saveRecords() {
		Json json = new Json();

		Information info_init = new Information();
		info_init.setFirstName("Alex");
		info_init.setMiddleName("Ivan");
		info_init.setLastName("Samuel");
		info_init.setPlaceOfBirth("New York");
		info_init.setPlaceOfDeath("Chicago");

		String fileName = "./src/test/resources/org/gradle/JsonTest_SaveRecords.txt";

		json.saveRecords(mapper, info_init, fileName);

		Information info_result = json.loadAllRecords(mapper, fileName);

		AssertJUnit.assertEquals(info_init.getLastName(),
				info_result.getLastName());
		AssertJUnit.assertEquals(info_init.getFirstName(),
				info_result.getFirstName());
		AssertJUnit.assertEquals(info_init.getMiddleName(),
				info_result.getMiddleName());
		AssertJUnit.assertEquals(info_init.getYearsOfLife(),
				info_result.getYearsOfLife());
		AssertJUnit.assertEquals(info_init.getPlaceOfBirth(),
				info_result.getPlaceOfBirth());
		AssertJUnit.assertEquals(info_init.getPlaceOfDeath(),
				info_result.getPlaceOfDeath());
		AssertJUnit.assertEquals(info_init.getCurrentAddress(),
				info_result.getCurrentAddress());
	}
}

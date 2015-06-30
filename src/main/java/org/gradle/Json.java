package org.gradle;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	// Read all JSON data from TXT file and put them to Information object and
	// return this object
	public static Information loadAllRecords(ObjectMapper mapper,
			String fileName) {
		Information information = new Information();
		try {
			File file = new File(fileName);
			if (file.exists()) {
				information = mapper.readValue(file, Information.class);
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return information;
	}

	// Save all information from the web page to TXT file in JSON format
	public static void saveRecords(ObjectMapper mapper,
			Information information, String personalCardId, String folderName) {
		String fileName = folderName + personalCardId + ".txt";
		information.setId(personalCardId);
		try {
			mapper.writeValue(new File(fileName), information);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

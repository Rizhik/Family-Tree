package org.gradle;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	// Read all JSON data from TXT file and put them to Information object and return this object
	public Information loadAllRecords(ObjectMapper mapper, String fileName) {
		Information information = new Information();
		try {
			File file = new File(fileName);
			if (file.exists()) {
				information = mapper.readValue(new File(fileName),
						Information.class);
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

	//Save all information from the web page to TXT file in JSON format
	public void saveRecords(ObjectMapper mapper, Information information,
			String fileName) {
		
		File file = new File(fileName);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
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

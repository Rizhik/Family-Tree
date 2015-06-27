package org.gradle;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonViewer {

	public ArrayList<String> getListOfRecords() {
		ArrayList<String> listOfCards = new ArrayList<String>();
		File folder = new File("./user_cards");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				String fileName = listOfFiles[i].getName();
				String personalID = fileName.substring(0,
						fileName.lastIndexOf('.'));
				String extension = fileName
						.substring(fileName.lastIndexOf('.') + 1);
				if (extension.equals("txt")) {
					listOfCards.add(personalID);
				}
			}
		}
		return listOfCards;
	}

	public ArrayList<Information> getListOfFamilyMembers() {
		PersonViewer pv = new PersonViewer();
		ArrayList<String> files = pv.getListOfRecords();
		ArrayList<Information> allPeople = new ArrayList<Information>();
		ObjectMapper mapper = new ObjectMapper();
		for (int index = 0; index < files.size(); index++) {
			String fileName = "./user_cards/" + files.get(index) + ".txt";
			Information currentPerson = Json.loadAllRecords(mapper, fileName);
			allPeople.add(currentPerson);
		}
		return allPeople;
	}

}

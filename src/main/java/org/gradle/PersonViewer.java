package org.gradle;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonViewer {

	public ArrayList<String> getListOfRecords(String folderName) {
		ArrayList<String> listOfCards = new ArrayList<String>();
		File folder = new File(folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}

		File[] listOfFiles = folder.listFiles();
		if (listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {

				if (listOfFiles[i].isFile()) {
					String fileName = listOfFiles[i].getName();
					String personalID = fileName.substring(0,
							fileName.lastIndexOf('.'));
					String extension = fileName.substring(fileName
							.lastIndexOf('.') + 1);
					if (extension.equals("txt")) {
						listOfCards.add(personalID);
					}
				}
			}
		}

		return listOfCards;

	}

	public ArrayList<Information> getListOfFamilyMembers(String folderName) {
		PersonViewer pv = new PersonViewer();
		ArrayList<String> files = pv.getListOfRecords(folderName);
		ArrayList<Information> allPeople = new ArrayList<Information>();
		ObjectMapper mapper = new ObjectMapper();
		for (int index = 0; index < files.size(); index++) {
			String fileName = folderName + files.get(index) + ".txt";
			Information currentPerson = Json.loadAllRecords(mapper, fileName);
			allPeople.add(currentPerson);
		}
		return allPeople;
	}

}

package org.gradle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PersonViewerTest {
	/* Verify the following cases:
	 * 		- Find all files with .txt in one folder
	 * 		- Don't count any .txt file in sub-folders
	 * 		- Don't count any folders
	 * 		- Don't count any files with extensions other than .txt
	 *      - Folder doesn't exist
	 * 		- Folder is empty
	 * */
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws IOException {
		File folder = new File(
				"./src/test/resources/org/gradle/PersonVieweTest");
		folder.mkdir();

		File folder2 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Sub-Test");
		folder2.mkdir();

		File wrong_location = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Sub-Test/Wrong_location.txt");
		wrong_location.createNewFile();

		File file1 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Test1.txt");
		file1.createNewFile();

		File file2 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Test2.txt");
		file2.createNewFile();

		File file3 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Test3.txt");
		file3.createNewFile();

		File wrong_file = new File(
				"./src/test/resources/org/gradle/PersonVieweTest/Wrong_File.txw");
		wrong_file.createNewFile();
	}

	@Test
	public void getListOfFamilyMembers() {
		PersonViewer pv = new PersonViewer();
		ArrayList<Information> result = pv
				.getListOfFamilyMembers("./src/test/resources/org/gradle/PersonVieweTest");
		AssertJUnit.assertEquals(3, result.size());
		AssertJUnit.assertNotNull(result.get(0).getId());
		AssertJUnit.assertNotNull(result.get(1).getId());
		AssertJUnit.assertNotNull(result.get(2).getId());
	}

	@Test
	public void getListOfRecords() {
		PersonViewer pv = new PersonViewer();
		ArrayList<String> result = pv
				.getListOfRecords("./src/test/resources/org/gradle/PersonVieweTest");
		AssertJUnit.assertEquals(3, result.size());
		AssertJUnit.assertEquals("Test1", result.get(0));
		AssertJUnit.assertEquals("Test2", result.get(1));
		AssertJUnit.assertEquals("Test3", result.get(2));
	}
	
	@Test
	public void getListOfRecords_FolderIsEmpty() {
		PersonViewer pv = new PersonViewer();
		
		File emptyFolder = new File(
				"./src/test/resources/org/gradle/PersonVieweTest2");
		emptyFolder.mkdir();
		ArrayList<String> result = pv
				.getListOfRecords("./src/test/resources/org/gradle/PersonVieweTest2");
		AssertJUnit.assertEquals(0, result.size());
	}
	
	@Test
	public void getListOfFamilyMembers_FolderIsEmpty() {
		PersonViewer pv = new PersonViewer();
		
		File emptyFolder = new File(
				"./src/test/resources/org/gradle/PersonVieweTest3");
		emptyFolder.mkdir();
		ArrayList<Information> result = pv
				.getListOfFamilyMembers("./src/test/resources/org/gradle/PersonVieweTest3");
		AssertJUnit.assertEquals(0, result.size());
	}

	@Test
	public void getListOfRecords_FolderDoesNOTExist() {
		PersonViewer pv = new PersonViewer();
		
		ArrayList<String> result = pv
				.getListOfRecords("./src/test/resources/org/gradle/PersonVieweTest4");
		AssertJUnit.assertEquals(0, result.size());
	}
	
	@Test
	public void getListOfFamilyMembers_FolderDoesNOTExist() {
		PersonViewer pv = new PersonViewer();
		
		ArrayList<Information> result = pv
				.getListOfFamilyMembers("./src/test/resources/org/gradle/PersonVieweTest5");
		AssertJUnit.assertEquals(0, result.size());
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		File folderwithTestData = new File(
				"./src/test/resources/org/gradle/PersonVieweTest");
		deleteFolder(folderwithTestData);
		
		File emptyFolder = new File(
				"./src/test/resources/org/gradle/PersonVieweTest2");
		deleteFolder(emptyFolder);
		
		File emptyFolder2 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest3");
		deleteFolder(emptyFolder2);
		
		File folderDoesNotExist = new File(
				"./src/test/resources/org/gradle/PersonVieweTest4");
		deleteFolder(folderDoesNotExist);
		
		File folderDoesNotExist2 = new File(
				"./src/test/resources/org/gradle/PersonVieweTest5");
		deleteFolder(folderDoesNotExist2);

	}

	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (int i=0; i<files.length;i++){
				if (files[i].isDirectory()) {
					deleteFolder(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		folder.delete();
	}
}

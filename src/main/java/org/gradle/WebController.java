package org.gradle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	public void completeHTMLPage(Model model, String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		Information information = Json.loadAllRecords(mapper, "./user_cards/"
				+ fileName + ".txt");
		model.addAttribute("info", information);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/delete").setViewName("main_page");
	}

	@RequestMapping(value = "/main_page", method = RequestMethod.GET)
	public String displayMainPage(Model model) {
		PersonViewer cv = new PersonViewer();
		ArrayList<Information> people = cv
				.getListOfFamilyMembers("./user_cards");
		model.addAttribute("cards", people);
		return "main_page";
	}

	@RequestMapping(value = "/personal_page_add", method = RequestMethod.GET)
	public String addNewPage(Model model) {
		model.addAttribute("info", new Information());
		return "personal_page_add";
	}

	@RequestMapping(value = "/personal_page_add", method = RequestMethod.POST)
	public String saveNewPersonalCard(Information info) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String fileName = "./user_cards/" + info.getId() + ".txt";
		File file = new File(fileName);
		try {
			file.createNewFile();
			mapper.writeValue(new File(fileName), info);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Json.saveRecords(mapper, info, info.getId(), "./user_cards/");
		return "redirect:/personal_page/" + info.getId();
	}

	@RequestMapping(value = "/personal_page/{personalCardId}", method = RequestMethod.GET)
	public String displayPersonalCard(@PathVariable String personalCardId,
			Model model) {
		completeHTMLPage(model, personalCardId);
		return "personal_page";
	}

	@RequestMapping(value = "/personal_page_edit/{personalCardId}", method = RequestMethod.GET)
	public String openForEditing(Model model,
			@PathVariable String personalCardId) {
		completeHTMLPage(model, personalCardId);
		return "personal_page_edit";
	}

	@RequestMapping(value = "/personal_page_edit/{personalCardId}", method = RequestMethod.POST)
	public String saveChanges(Information information,
			@PathVariable String personalCardId) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Json.saveRecords(mapper, information, personalCardId, "./user_cards/");
		return "redirect:/personal_page/" + personalCardId;
	}

	@RequestMapping(value = "/delete/{personalCardId}", method = RequestMethod.POST)
	public String deletePersonalCard(@PathVariable String personalCardId)
			throws IOException {
		String fileName = "./user_cards/" + personalCardId + ".txt";
		File file = new File(fileName);
		Path path = file.toPath();
		Files.deleteIfExists(path);
		return "redirect:/main_page/";
	}
}

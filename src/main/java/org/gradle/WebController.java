package org.gradle;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
	static String fileName = "Test.txt";
	Information information = new Information();

	public void completeHTMLPage(Model model) {
		Json json = new Json();
		ObjectMapper mapper = new ObjectMapper();
		information = json.loadAllRecords(mapper, fileName);

		model.addAttribute("info", information);
	}

	@RequestMapping(value = "/personal_page", method = RequestMethod.GET)
	public String displayPersonlaPageInViewMode(Model model) {
		completeHTMLPage(model);
		return "personal_page";
	}

	@RequestMapping(value = "/personal_page_edit", method = RequestMethod.GET)
	public String displayPersonalPageInEditMode(Model model) {
		completeHTMLPage(model);

		return "personal_page_edit";
	}

	@RequestMapping(value = "/personal_page_edit", method = RequestMethod.POST)
	public String editPersonalInformation(Information information)
			throws IOException {
		Json json = new Json();
		ObjectMapper mapper = new ObjectMapper();
		json.saveRecords(mapper, information, fileName);
		return "redirect:/personal_page";
	}
}

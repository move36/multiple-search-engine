package org.move36.searchEngine.web.controllers;

import org.move36.searchEngine.search.MultipleWebSearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Controller for searchs
 * 
 * @author javiersevilla
 *
 */
@Controller
public class SearchTermController {

	@Autowired
	private MultipleWebSearchEngine multipleWebSearchEngine;

	@RequestMapping(value = "search")
	public String get(Model model, @RequestParam String term) throws Exception {
		model.addAttribute("results", multipleWebSearchEngine.search(term));
		return "results";
	}
}

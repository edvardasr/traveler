package com.traveler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.traveler.entities.Backpack;
import com.traveler.repository.Repository;

@Controller
public class TravelerController {

	private static final Logger logger = LoggerFactory.getLogger(TravelerController.class);

	@Autowired
	private Repository repository;

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showForm() {
		
		return new ModelAndView("generationHome", "backpack", new Backpack());
	}
	
	@RequestMapping(value = "/generateBackpack", method = RequestMethod.POST)
	public String generateBackpack(@ModelAttribute("backpack") Backpack backpack, BindingResult result,
			ModelMap model) {
	
		model.addAttribute("distance", backpack.getDistance());
		model.addAttribute("bodyWeight", backpack.getBodyWeight());
		model.addAttribute("date", backpack.getDate());

		return "generateBackpack";
	}

	@RequestMapping(value = "/generateBackpack", method = RequestMethod.POST, params = "submit")
	public String submit(@ModelAttribute("backpack") Backpack backpack, BindingResult result,
			ModelMap model) {
	
		Backpack outcome = repository.generateBackpack(backpack);
		
		if (outcome == null) {
			return "error";
		}
		
		logger.debug("generated backpack:{}", backpack);
		
		return "showBackpack";
	}

	@RequestMapping(value = "/generateBackpack", method = RequestMethod.POST, params = "cancel")
	public String cancel(@ModelAttribute("backpack") final Backpack backpack, final BindingResult result,
			final ModelMap model) {
		model.addAttribute("message", "You clicked cancel, please re-enter details:");
		
		return "generationHome";
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

}
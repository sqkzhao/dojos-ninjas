package com.kayz.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kayz.dojosninjas.models.Dojo;
import com.kayz.dojosninjas.models.Ninja;
import com.kayz.dojosninjas.services.DojoService;
import com.kayz.dojosninjas.services.NinjaService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
//	Autowired same as line 20 - 23
//	private final DojoService dojoService;
//	public DojoController(DojoService dojoService) {
//		this.dojoService = dojoService;
//	}
	@Autowired
	private NinjaService ninjaService;
	
	// CREATE DOJO
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojo/new.jsp";
	}
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/new.jsp";
		} else {
			dojoService.create(dojo);
			return "redirect:/dojos/new";
		}
	}
	// CREATE NINJA
		@GetMapping("/ninjas/new")
		public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
			List<Dojo> allDojos = dojoService.getAllDojos();
			model.addAttribute("allDojos", allDojos);
			return "/ninja/new.jsp";
		}
		@PostMapping("/ninjas/new")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Dojo> allDojos = dojoService.getAllDojos();
				model.addAttribute("allDojos", allDojos);
				return "/ninja/new.jsp";
			} else {
				ninjaService.create(ninja);
				return "redirect:/ninjas/new";
			}
		}
		
	// DISPLAY NINJA
	@GetMapping("/ninjas/{id}")
	public String displayNinja(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/ninja/display.jsp";
	}
}

package com.football.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.football.domain.Live;
import com.football.service.HlService;
import com.football.service.LiveService;

@Controller
public class LiveController {
	
	@Autowired LiveService liveService;
	
	@GetMapping("/livestream")
	public String index(Model model) {
		model.addAttribute("lives", liveService.findAll());
		return "livestream/live_list";
	}
	
	@GetMapping("/livestream/add")
	public String create_live(Model model) {
		model.addAttribute("live", new Live());
		return "livestream/live_form";
	}
	
	@PostMapping("/livestream/submit")
	public String save_live(@Valid Live live, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "livestream/live_form";
		}
		liveService.save(live);
		return "redirect:/livestream";
	}
	
	@GetMapping("/livestream/{id_live}/edit")
	public String edit_live(@PathVariable int id_live, Model model, RedirectAttributes redirect) {
		model.addAttribute("live", liveService.findOne(id_live));
		return "livestream/live_form";
	}
	
	@GetMapping("/livestream/{id_live}/delete")
	public String delete_live(@PathVariable int id_live, RedirectAttributes redirect) {
		liveService.delete(id_live);
		return "redirect:/livestream";
	}
	
//	@GetMapping("/livestream/search")
//	public String search_live(@RequestParam("f") String f, Model model) {
//		if(f.equals("")) {
//			return "redirect:/livestream";
//		}
//		model.addAttribute("lives", liveService.search(f));
//		return "live_list";
//	}
	
	
}

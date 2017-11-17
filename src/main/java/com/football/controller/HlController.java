package com.football.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.football.domain.Highlight;
import com.football.service.HlService;
import com.football.service.HlServiceImpl;

@Controller
public class HlController {

	@Autowired
	HlService hlService;

	@GetMapping("/highlight")
	public String index(Model model) {
		model.addAttribute("highlights", hlService.findAll());
		return "highlight/hl_list";
	}

	@GetMapping("/highlight/add")
	public String create_hl(Model model) {
		model.addAttribute("highlight", new Highlight());
		return "highlight/hl_form";
	}

	@PostMapping("/highlight/submit")
	public String save_hl(@Valid Highlight highlight, BindingResult result) {
		if (result.hasErrors()) {
			return "highlight/hl_form";
		}
		hlService.save(highlight);
		return "redirect:/highlight";
	}

	@GetMapping("/highlight/{id_hl}/edit")
	public String edit_hl(@PathVariable int id_hl, Model model) {
		model.addAttribute("highlight", hlService.findOne(id_hl));
		return "highlight/hl_form";
	}

	@GetMapping("/highlight/{id_hl}/delete")
	public String delete_hl(@PathVariable int id_hl) {
		hlService.delete(id_hl);
		return "redirect:/highlight";
	}

	@GetMapping("/highlight/crawl")
	public String data() throws ParseException, IOException {
		List<Highlight> list = HlServiceImpl.getDataParseTrucTiepHD();
		for (Highlight highlight : list) {
			hlService.save(highlight);
		}
		return "redirect:/highlight";
	}
	
	

}

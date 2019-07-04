package com.devpro.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.devpro.spring.model.Chamber;
import com.devpro.spring.service.ChamberService;

@Controller
public class ChamberController {

	@Autowired
	private ChamberService chamberService;
	
	@GetMapping("/chambers")
	public String loadListChambers(Model model){
		model.addAttribute("chambers", chamberService.findAllChamber());
		return "chamber";
	}
	
	@GetMapping("/update-chamber-info")
	public String updateChamber(@Valid Chamber chamber, BindingResult result) {
		chamberService.editChamberInfo(chamber);
		return "chamber";
		
	}
	
	@GetMapping("/save-chamber-info")
	public String saveChamber(@Valid Chamber chamber, BindingResult result) {
		chamberService.addChamberInfo(chamber);
		return "chamber";
		
	}
}

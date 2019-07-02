package com.devpro.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.devpro.spring.model.Guest;
import com.devpro.spring.service.GuestService;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@GetMapping("/guests")
	public String loadListGuests(Model model){
		model.addAttribute("guests", guestService.findAllGuest());
		return "guest";
	}
	
	@GetMapping("/update-guest-info")
	public String updateGuestInfo(@Valid Guest guest,BindingResult result) {
		guestService.editGuestInfo(guest);
		return "guest";
	}
}

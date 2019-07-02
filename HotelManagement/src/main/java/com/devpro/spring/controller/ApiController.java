package com.devpro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devpro.spring.model.Guest;
import com.devpro.spring.service.GuestService;

@RestController
public class ApiController {
	
	@Autowired
	private GuestService guestService;

	@GetMapping("/findOne")
	@ResponseBody
	public Guest createFindOne(@RequestParam("id") Long id) {
		return guestService.findGuest(id);
	}
}

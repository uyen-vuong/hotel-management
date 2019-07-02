package com.devpro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devpro.spring.model.AppUser;
import com.devpro.spring.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("infor")
	public String showInfor(Model model) {
		List<AppUser> listUsers = userService.getList();
		model.addAttribute("listUsers", listUsers);
		return "userInfor";
	}
}

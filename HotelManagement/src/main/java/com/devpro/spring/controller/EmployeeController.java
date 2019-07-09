package com.devpro.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.devpro.spring.model.Employee;
import com.devpro.spring.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String loadListEmployees(Model model){
		model.addAttribute("employees", employeeService.findAllEmployee());
		return "employee";
	}
	
	@GetMapping("/update-employee-info")
	public String updateEmployeeInfo(@Valid Employee employee,BindingResult result) {
		employeeService.editEmployeeInfo(employee);
		return "employee";
	}
}

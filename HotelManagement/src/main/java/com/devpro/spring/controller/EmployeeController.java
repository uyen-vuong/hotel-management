package com.devpro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devpro.spring.model.Employee;
import com.devpro.spring.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String loadListEmployees(Model model,
			@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "search-text", defaultValue = "") String text){
		Pageable pageable = PageRequest.of(page, 10);
		Page<Employee> pages = employeeService.searchEmployees(pageable, text);
		List<Employee> list = employeeService.searchEmployees(text);
		int current = pages.getNumber() + 1;
		long total = pages.getTotalPages();
		int begin = Math.max(1, (current - list.size()));
		long end = 1;
		if(total != 0) {
			end = Math.min(begin + 5, total);
		}
		String baseUrl = "/employees?page=";
		String searchUrl = "&search-text="+text;
		
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", total);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);
		model.addAttribute("searchUrl", searchUrl);
		model.addAttribute("searchText", text);
		return "employee";
	}
	
	@PostMapping("/update-employee-info")
	public String updateEmployeeInfo(
			@RequestParam(name = "id") Long employeeId,
			@RequestParam(name = "number") String employeeNumber,
			@RequestParam(name = "name") String employeeName,
			@RequestParam(name = "birth") String birth,
			@RequestParam(name = "gender") String gender,
			@RequestParam(name = "address") String address,
			@RequestParam(name = "position") String employeePosition,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "phone") String phoneNumber,
			@RequestParam(name = "salary") String salary,
			@RequestParam(name = "managerId") Long managerId,
			@RequestParam(name = "page") int page,
			@RequestParam(name = "text") String text) {
		Employee employee = new Employee(employeeId, employeeNumber, employeeName, birth, gender, address, employeePosition, email, phoneNumber, salary, managerId, null);
		employeeService.editEmployeeInfo(employee);
		return "redirect:/employees?page="+page+"&search-text="+text;
	}
	
	@GetMapping("/find-employee")
	@ResponseBody
	public Employee findOneEmployee(Long id) {
		return employeeService.findEmployee(id);
		
	}
}

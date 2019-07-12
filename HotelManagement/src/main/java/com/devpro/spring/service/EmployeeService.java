package com.devpro.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devpro.spring.model.Employee;

public interface EmployeeService {

	Employee findEmployee(Long id);
	
	Page<Employee> searchEmployees(Pageable pageable, String text);
	
	List<Employee> searchEmployees(String text);
	
	void addEmployeeInfo(Employee employee);
	
	void editEmployeeInfo(Employee employee);
}

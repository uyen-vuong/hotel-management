package com.devpro.spring.service;

import java.util.List;

import com.devpro.spring.model.Employee;

public interface EmployeeService {

	Employee findEmployee(Long id);
	
	List<Employee> findAllEmployee();
	
	void addEmployeeInfo(Employee employee);
	
	void editEmployeeInfo(Employee employee);
}

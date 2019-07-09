package com.devpro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpro.spring.model.Employee;
import com.devpro.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findEmployee(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.getOne(id);
	}

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployeeInfo(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void editEmployeeInfo(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}
	
	
}

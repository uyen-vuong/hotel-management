package com.devpro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}

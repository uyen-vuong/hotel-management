package com.devpro.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devpro.spring.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(CustomQuery.EMPLOYEE_SEARCH)
	Page<Employee> searchEmployees(Pageable pageable, @Param("text") String text);

	@Query(CustomQuery.EMPLOYEE_SEARCH)
	List<Employee> searchEmployees(@Param("text") String text);
}

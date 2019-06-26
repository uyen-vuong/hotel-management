package com.devpro.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.devpro.spring.model.UserRole;
import com.devpro.spring.repository.UserRoleRepository;



public class UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public void saveUserRole(UserRole userRole) {
		userRoleRepository.save(userRole);
	}
}

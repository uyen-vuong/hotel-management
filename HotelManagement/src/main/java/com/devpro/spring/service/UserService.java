package com.devpro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devpro.spring.model.AppUser;
import com.devpro.spring.repository.UserRepository;



@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<AppUser> getList(){
		return userRepository.findAll();
	}
}

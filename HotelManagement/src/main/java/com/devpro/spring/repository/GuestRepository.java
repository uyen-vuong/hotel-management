package com.devpro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devpro.spring.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{
	
	
}

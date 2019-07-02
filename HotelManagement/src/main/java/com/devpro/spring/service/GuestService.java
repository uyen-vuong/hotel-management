package com.devpro.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devpro.spring.model.Guest;

public interface GuestService {
	
	Guest findGuest(Long id);
	
	Page<Guest> findAllGuest(Pageable pageable);
	
	List<Guest> findAll();
	
	void addGuestInfo(Guest guest);
	
	void editGuestInfo(Guest guest);

}

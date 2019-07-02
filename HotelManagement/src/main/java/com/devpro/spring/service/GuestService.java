package com.devpro.spring.service;

import java.util.List;

import com.devpro.spring.model.Guest;

public interface GuestService {
	
	Guest findGuest(Long id);
	
	List<Guest> findAllGuest();
	
	void addGuestInfo(Guest guest);
	
	void editGuestInfo(Guest guest);

}

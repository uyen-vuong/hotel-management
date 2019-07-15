package com.devpro.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devpro.spring.model.Guest;

public interface GuestService {
	
	Guest findGuest(Long id);
	
	Page<Guest> searchGuests(Pageable pageable,String text);
	
	List<Guest> searchGuests(String text);
	
	void addGuestInfo(Guest guest);
	
	void editGuestInfo(Guest guest);
	
	Guest searchGuestJustInsertd(String passport,String idCard,String phoneNumber);
	
	Integer checkExistGuest(String idCard,String phoneNumber,String passport);

}

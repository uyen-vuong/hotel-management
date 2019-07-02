package com.devpro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpro.spring.model.Guest;
import com.devpro.spring.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository guestRepository;
	
	@Override
	public Guest findGuest(Long id) {
		// TODO Auto-generated method stub
		return guestRepository.getOne(id);
	}

	@Override
	public List<Guest> findAllGuest() {
		// TODO Auto-generated method stub
		return guestRepository.findAll();
	}

	@Override
	public void addGuestInfo(Guest guest) {
		// TODO Auto-generated method stub
		guestRepository.save(guest);
	}

	@Override
	public void editGuestInfo(Guest guest) {
		// TODO Auto-generated method stub
		guestRepository.save(guest);
	}


}

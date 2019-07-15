package com.devpro.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpro.spring.model.Rental;
import com.devpro.spring.repository.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService{

	@Autowired
	private RentalRepository rentalRepository;
	
	@Override
	public void addRentalInfo(Rental rental) {
		// TODO Auto-generated method stub
		rentalRepository.save(rental);
	}

}

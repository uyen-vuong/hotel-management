package com.devpro.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devpro.spring.model.Chamber;
import com.devpro.spring.repository.ChamberRepository;

@Service
public class ChamberServiceImpl implements ChamberService{

	@Autowired
	private ChamberRepository chamberRepository;
	
	@Override
	public Chamber findChamber(Long id) {
		// TODO Auto-generated method stub
		return chamberRepository.getOne(id);
	}

	@Override
	public List<Chamber> findAllChamber() {
		// TODO Auto-generated method stub
		return chamberRepository.findAll();
	}

	@Override
	public void addChamberInfo(Chamber chamber) {
		// TODO Auto-generated method stub
		chamberRepository.save(chamber);
	}

	@Override
	public void deleteChamberInfo(Chamber chamber) {
		// TODO Auto-generated method stub
		chamberRepository.save(chamber);
	}

	@Override
	public void editChamberInfo(Chamber chamber) {
		// TODO Auto-generated method stub
		chamberRepository.save(chamber);
	}

	
}

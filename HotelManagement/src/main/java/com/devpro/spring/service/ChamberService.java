package com.devpro.spring.service;

import java.util.List;

import com.devpro.spring.model.Chamber;

public interface ChamberService {

	Chamber findChamber(Long id);
	
	List<Chamber> findAllChamber();
	
	void addChamberInfo(Chamber chamber);
	
	void deleteChamberInfo(Chamber chamber);
	
	void editChamberInfo(Chamber chamber);
}

package com.devpro.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devpro.spring.model.Chamber;

public interface ChamberService {

	Chamber findChamber(Long id);
	
	Page<Chamber> findAllChamber(Pageable pageable);
	
	Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type,String vip);
	
	Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type,String vip);
	
	Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type,String vip);
	
	void addChamberInfo(Chamber chamber);
	
	void deleteChamberInfo(Chamber chamber);
	
	void editChamberInfo(Chamber chamber);
	
	void updateCheckIn(Long id);
}

package com.devpro.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<Chamber> findAllChamber(Pageable pageable) {
		// TODO Auto-generated method stub
		return chamberRepository.findAll(pageable);
	}

	@Override
	public Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type, String vip) {
		return chamberRepository.searchChamberWithPrice1(pageable,type, vip);
	}

	@Override
	public Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type, String vip) {
		// TODO Auto-generated method stub
		return chamberRepository.searchChamberWithPrice2(pageable,type, vip);
	}

	@Override
	public Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type, String vip) {
		// TODO Auto-generated method stub
		return chamberRepository.searchChamberWithPrice3(pageable,type, vip);
	}

	@Override
	public void updateCheckIn(Long id) {
		chamberRepository.updateChamberIsEmpty("false", id);
	}

	
}

package com.devpro.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devpro.spring.model.Chamber;

public interface ChamberService {
	//tìm kiếm phòng theo id(id ở dạng long)
	Chamber findChamber(Long id);
	
	// tìm kiếm phòng theo các thông tin khác( các thông tin khác ở dạng string)
	Page<Chamber> searchChamber(Pageable pageable,String text);
	
	// quản lý đặt phòng
	// tìm kiếm phòng theo 3 mức độ giá : dưới 1 triệu, từ 1 đến 3 tr, trên 3tr.
	Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type,String vip);
	
	Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type,String vip);
	
	Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type,String vip);
	
	// thêm phòng
	void addChamber(String number, String type, String price, String area, String note, String fvip);
	
	// xóa phòng
	void deleteChamber(Long chamberId);
	
	void updateCheckIn(Long id); // update lai trang thai phong khi check in
	
	// sửa thông tin phòng
	void updateChamberInfo(String number, String type, String price, String area, String note, String vip,Long id);
	
	
}

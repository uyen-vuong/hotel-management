package com.devpro.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.devpro.spring.model.Chamber;
import com.devpro.spring.model.Guest;
import com.devpro.spring.model.Rental;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class CheckOutDto {
	@Id
	private String type;
	private String price;
	private String vip;

	private String name;
	private String birth;
	private String address;
	private String phone;
	private String card;
	private String passport;
	private String nationality;
	private String email;

	private String checkInDate;
	private String numberStay;
	private String total;
	
	private String rent;
	private String food;
	private String service;
	private String note;
	private String rentalId;
	
	public CheckOutDto(Rental rental, Chamber chamber, Guest guest, Integer numberStay, Integer totalPriceFood,
			Integer totalPriceService) {
		int rentT;int foodT;int serviceT; 
		if(numberStay==0 || numberStay == null) {
			this.numberStay = "0";
			rentT = (int) (Integer.parseInt(chamber.getPriceDay())*0.5);
			this.rent = String.valueOf(rentT);
			// tra phong trong ngay lay nua so tien
		}else {
			this.numberStay = String.valueOf(numberStay);
			rentT = (int)Integer.parseInt(chamber.getPriceDay())*numberStay;
			this.rent = String.valueOf(rentT);
		}
		
		if(totalPriceFood==null) {
			this.food = "0";
			foodT = 0;
		}else {
			foodT = totalPriceFood;
			this.food = String.valueOf(foodT);
		}
		
		if(totalPriceService==null) {
			this.service = "0";
			serviceT = 0;
		}else {
			serviceT = totalPriceService;
			this.service = String.valueOf(serviceT);
		}
		
		this.type = chamber.getChamberType();
		this.price = chamber.getPriceDay();
		this.vip = chamber.getIsVip();
		this.name = guest.getGuestName();
		this.birth = guest.getBirth();
		this.address = guest.getAddress();
		this.phone = guest.getPhoneNumber();
		this.card = guest.getIdCard();
		this.passport = guest.getPassport();
		this.nationality = guest.getNationality();
		this.email = guest.getEmail();
		this.checkInDate = String.valueOf(rental.getCheckInDate());
		this.rentalId = String.valueOf(rental.getRentalId());
		this.note = rental.getNote();
		this.total = String.valueOf(rentT+foodT+serviceT);
	}

}

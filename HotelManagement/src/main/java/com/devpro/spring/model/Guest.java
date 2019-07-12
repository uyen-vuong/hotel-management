package com.devpro.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "guest_id")
	private long guestId;
	
	@Column(name = "guest_name")
	private String guestName;
	
	public Guest(Long guestId, String guestName, String birth, String idCard, String passport, String address,
			String nationality, String phoneNumber, String isVip) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.birth = birth;
		this.idCard = idCard;
		this.passport = passport;
		this.address = address;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.isVip = isVip;
	}

	@Column(name = "birth")
	private String birth;
	
	@Column(name = "id_card")
	private String idCard;
	
	@Column(name = "passport")
	private String passport;
	
	@Column(name = "address")
	private String address;

	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_vip")
	private String isVip;
	
	public Guest() {
		super();
	}
	
	@OneToOne(mappedBy = "guest")
	private Rental rental;

	public long getGuestId() {
		return guestId;
	}

	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Guest(Long guestId, String guestName, String birth, String idCard, String passport, String address,
			String nationality, String phoneNumber, String isVip, Rental rental) {
		super();
		this.guestId = guestId;
		this.guestName = guestName;
		this.birth = birth;
		this.idCard = idCard;
		this.passport = passport;
		this.address = address;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.isVip = isVip;
		this.rental = rental;
	}

	public Guest(String guestName, String birth, String idCard, String passport, String address, String nationality,
			String phoneNumber, String isVip) {
		super();
		this.guestName = guestName;
		this.birth = birth;
		this.idCard = idCard;
		this.passport = passport;
		this.address = address;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.isVip = isVip;
	}

	
}

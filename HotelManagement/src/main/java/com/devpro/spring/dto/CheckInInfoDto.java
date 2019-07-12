package com.devpro.spring.dto;

public class CheckInInfoDto {

	private String name;
	private String idCard;
	private String birth;
	private String passport;
	private String address;
	private String nationality;
	private String phone;
	private String note;
	private Long chamberId;
	
	public CheckInInfoDto() {
		super();
	}
	public CheckInInfoDto(String name, String idCard, String birth, String passport, String address, String nationality,
			String phone, String note, Long chamberId) {
		super();
		this.name = name;
		this.idCard = idCard;
		this.birth = birth;
		this.passport = passport;
		this.address = address;
		this.nationality = nationality;
		this.phone = phone;
		this.note = note;
		this.chamberId = chamberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getChamberId() {
		return chamberId;
	}
	public void setChamberId(Long chamberId) {
		this.chamberId = chamberId;
	}
}

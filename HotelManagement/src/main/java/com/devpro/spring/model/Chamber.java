package com.devpro.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chamber")
public class Chamber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "chamber_id")
	private Long chamberId;
	
	@Column(name = "chamber_number")
	private String chamberNumber;
	
	@Column(name = "chamber_type")
	private String chamberType;
	
	@Column(name = "is_vip")
	private String isVip;
	
	@Column(name = "price_day")
	private String priceDay;
	
	@Column(name = "chamber_area")
	private String chamberArea;
	
	@Column(name = "capacity")
	private String capacity;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "is_empty")
	private String isEmpty;

	public Chamber() {
		super();
	}
	
	public Chamber(Long chamberId, String chamberNumber, String chamberType, String isVip, String priceDay,
			String chamberArea, String capacity, String note, String isEmpty) {
		super();
		this.chamberId = chamberId;
		this.chamberNumber = chamberNumber;
		this.chamberType = chamberType;
		this.isVip = isVip;
		this.priceDay = priceDay;
		this.chamberArea = chamberArea;
		this.capacity = capacity;
		this.note = note;
		this.isEmpty = isEmpty;
	}

	public Long getChamberId() {
		return chamberId;
	}

	public void setChamberId(Long chamberId) {
		this.chamberId = chamberId;
	}

	public String getChamberNumber() {
		return chamberNumber;
	}

	public void setChamberNumber(String chamberNumber) {
		this.chamberNumber = chamberNumber;
	}

	public String getChamberType() {
		return chamberType;
	}

	public void setChamberType(String chamberType) {
		this.chamberType = chamberType;
	}

	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public String getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(String priceDay) {
		this.priceDay = priceDay;
	}

	public String getChamberArea() {
		return chamberArea;
	}

	public void setChamberArea(String chamberArea) {
		this.chamberArea = chamberArea;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(String isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chamber [chamberId=");
		builder.append(chamberId);
		builder.append(", chamberNumber=");
		builder.append(chamberNumber);
		builder.append(", chamberType=");
		builder.append(chamberType);
		builder.append(", isVip=");
		builder.append(isVip);
		builder.append(", priceDay=");
		builder.append(priceDay);
		builder.append(", chamberArea=");
		builder.append(chamberArea);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append(", note=");
		builder.append(note);
		builder.append(", isEmpty=");
		builder.append(isEmpty);
		builder.append("]");
		return builder.toString();
	}
	
}

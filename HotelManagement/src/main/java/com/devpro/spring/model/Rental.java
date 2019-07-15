package com.devpro.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rental")
public class Rental {
	
	public Rental() {
		super();
	}

	public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Chamber getChamber() {
		return chamber;
	}

	public void setChamber(Chamber chamber) {
		this.chamber = chamber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rental_id")
	private Long rentalId;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "check_in_date")
	private String checkInDate;
	
	@Column(name = "check_out_date")
	private String checkOutDate;
	
	@Column(name = "paid")
	private String paid;
	
	@Column(name = "note")
	private String note;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "guest_id",referencedColumnName = "guest_id")
	private Guest guest;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chamber_id",referencedColumnName = "chamber_id")
	private Chamber chamber;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payment_id", nullable=false)
    private Payment payment;
	
}

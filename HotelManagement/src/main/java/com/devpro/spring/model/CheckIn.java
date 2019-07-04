package com.devpro.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class CheckIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "check_in_id")
	private Long checkInId;
	
	@Column(name = "check_in_date")
	private String checkInDate;
	
	@Column(name = "deposit")
	private String deposit;
	
	@Column(name = "note")
	private String note;
	
	public CheckIn() {
		super();
	}

	public CheckIn(Long checkInId, String checkInDate, String deposit, String note) {
		super();
		this.checkInId = checkInId;
		this.checkInDate = checkInDate;
		this.deposit = deposit;
		this.note = note;
	}

	public Long getCheckInId() {
		return checkInId;
	}

	public void setCheckInId(Long checkInId) {
		this.checkInId = checkInId;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CheckIn [checkInId=");
		builder.append(checkInId);
		builder.append(", checkInDate=");
		builder.append(checkInDate);
		builder.append(", deposit=");
		builder.append(deposit);
		builder.append(", note=");
		builder.append(note);
		builder.append("]");
		return builder.toString();
	}
	
	
}

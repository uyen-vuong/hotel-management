package com.devpro.spring.dto;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class CheckInInfoDto {
	@Id
	private long chamberId;
	private String name;
	private String idCard;
	private String birth;
	private String passport;
	private String address;
	private String nationality;
	private String phone;
	private String note;
	private String email;
	
}

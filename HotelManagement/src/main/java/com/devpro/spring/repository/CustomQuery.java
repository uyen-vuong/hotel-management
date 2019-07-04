package com.devpro.spring.repository;

public interface CustomQuery {

		String GUEST_SEARCH = "select g from Guest g where g.guestName like :text or g.birth like :text or g.idCard like :text or  g.passport like :text or g.address like :text or g.nationality like :text or g.phoneNumber like :text or g.isVip like :text";
	
}

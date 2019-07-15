package com.devpro.spring.repository;

public interface CustomQuery {

		String GUEST_SEARCH = "select g from Guest g where g.guestName like :text or g.birth like :text or g.idCard like :text or  g.passport like :text or g.address like :text or g.nationality like :text or g.phoneNumber like :text or g.isVip like :text";
		
		String CHAMBER_SEARCH_PRICE_1 = "select c from Chamber c where cast(c.priceDay as int) < 1000000 and c.chamberType = :chamberType and c.isVip = :isVip and c.isEmpty = 'true'";
		
		String CHAMBER_SEARCH_PRICE_2 = "select c from Chamber c where cast(c.priceDay as int) between 1000000 and 3000000 and c.chamberType = :chamberType and c.isVip = :isVip and c.isEmpty = 'true'";
		
		String CHAMBER_SEARCH_PRICE_3 = "select c from Chamber c where cast(c.priceDay as int) > 3000000 and c.chamberType = :chamberType and c.isVip = :isVip and c.isEmpty = 'true'";
		
		String CHAMBER_UPDATE_IS_EMPTY = "update Chamber set isEmpty=:isEmpty where chamberId=:chamberId";
		
		String GUEST_SEARCH_JUST_INSERTED = "select g from Guest g where g.passport = :passport or g.idCard = :idCard or g.phoneNumber = :phoneNumber";
		
		//nativeQuery
		String GUEST_CHECK_EXIST_DATABASE = "select count(*) from guest where guest.id_card = :idCard or guest.phone_number = :phoneNumber or guest.passport = :passport";
		
}

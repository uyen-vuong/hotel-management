package com.devpro.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devpro.spring.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{
	
	@Query(CustomQuery.GUEST_SEARCH)
	Page<Guest> searchGuests(Pageable pageable,@Param("text") String text);
	
	@Query(CustomQuery.GUEST_SEARCH)
	List<Guest> searchGuests(@Param("text") String text);
	
	@Query(CustomQuery.GUEST_SEARCH_JUST_INSERTED)
	Guest searchGuestJustInsertd(
			@Param("idCard") String idCard,
			@Param("passport") String passport,
			@Param("phoneNumber") String phoneNumber);
	
	@Query(value = CustomQuery.GUEST_CHECK_EXIST_DATABASE,nativeQuery = true)
	Integer checkExistGuest(
			@Param("idCard") String idCard,
			@Param("phoneNumber") String phoneNumber,
			@Param("passport") String passport
			);
}

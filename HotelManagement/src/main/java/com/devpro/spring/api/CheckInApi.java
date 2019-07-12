package com.devpro.spring.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devpro.spring.dto.CheckInInfoDto;
import com.devpro.spring.model.AjaxResponseBody;
import com.devpro.spring.model.Chamber;
import com.devpro.spring.model.Guest;
import com.devpro.spring.model.Rental;
import com.devpro.spring.service.ChamberService;
import com.devpro.spring.service.GuestService;
import com.devpro.spring.service.RentalService;

@RestController
public class CheckInApi {

	@Autowired
	private GuestService guestService;

	@Autowired
	private ChamberService chamberService;

	@Autowired
	private RentalService rentalService;

	@Transactional(rollbackFor = Exception.class)
	// rollback khi gap bat ki ngoai le nao CHUA DC xu ly, neu dc xu ly thi ko rollback nua
	@PostMapping("/rent-chamber")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody CheckInInfoDto checkin, Errors errors) {

		AjaxResponseBody result = new AjaxResponseBody();
		if (errors.hasErrors()) {

			result.setMessage(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
		}
		
		chamberService.updateCheckIn(checkin.getChamberId()); // doi trang thai phong thanh co nguoi o

		Chamber chamber = chamberService.findChamber(checkin.getChamberId()); // tim phong da thay doi t.thai o tren
		
		int check = guestService.checkExistGuest(checkin.getIdCard(), checkin.getPhone(), checkin.getPassport());
		
		if(check==1)
		{
			// set guest_fimilar = true;
			
		}
		else if(check==0){
			guestService.addGuestInfo(new Guest(checkin.getName(), checkin.getBirth(), checkin.getIdCard(), checkin.getPassport(),
					checkin.getAddress(), checkin.getNationality(), checkin.getPhone(), chamber.getIsVip())); // them moi khach
		}
		else {
			// truong hop csdl da co den 2 khach duplicate
		}
		
		Guest guestCheckExAndCheckInserted = guestService.searchGuestJustInsertd(checkin.getPassport(),
				checkin.getIdCard(), checkin.getPhone());
		// khach quen check-in se lay lai thong tin, khach moi check-in se dc them va csdl

		Rental rental = new Rental();
		rental.setChamber(chamber);
		rental.setGuest(guestCheckExAndCheckInserted);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		rental.setCheckInDate(formatter.format(date).toString()); // set ngay check in la ngay hom nay
		rental.setNote(checkin.getNote());
		rental.setPaid("false"); // khach chua co tra tien

		rentalService.addRentalInfo(rental); // them hoa don thue phong

		if (guestCheckExAndCheckInserted != null)
			result.setMessage("Check in thành công!");
		return ResponseEntity.ok(result);

	}
}

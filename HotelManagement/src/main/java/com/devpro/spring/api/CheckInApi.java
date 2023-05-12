package com.devpro.spring.api;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

@RestController // để đánh dấu lớp điều khiển cho Rest API
public class CheckInApi {

	@Autowired
	private GuestService guestService; // dịch vụ cho khách hàng

	@Autowired
	private ChamberService chamberService; // dịch vụ tại phòng

	@Autowired
	private RentalService rentalService;// dịch vụ trong toàn bộ khách sạn

	@Transactional(rollbackFor = Exception.class)
	// rollback khi gap bat ki ngoai le nao CHUA DC xu ly
	
	@PostMapping("/rent-chamber")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody CheckInInfoDto checkin, Errors errors) {

		AjaxResponseBody result = new AjaxResponseBody();
		
		// xử lý lỗi 
		if (errors.hasErrors()) {
			result.setMessage(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
			// nếu có lỗi thì trả về badrequest(dừng lại)
		}
		// nếu không có lỗi => check in thành công thì đổi trạng thái phòng thành có người
		chamberService.updateCheckIn(checkin.getChamberId()); 

		Chamber chamber = chamberService.findChamber(checkin.getChamberId()); 
	
		// tìm phòng đã thay đổi trạng thái ở trên theo idcard
		int check = guestService.checkExistGuest(checkin.getIdCard());
		// nếu check = 1 tức là đã tồn tại 1 tài khoản có idcard rồi
		if (check == 1) {
			guestService.updateComplete(checkin.getPassport(), checkin.getAddress(), checkin.getPhone(),
					checkin.getEmail(), chamber.getIsVip(), checkin.getIdCard());
			// bo sung thong tin con thieu cho khach hang
			
		} else if (check == 0) {
			// check = 0 tức là chưa có bản ghi nào thì mk cần thêm mới vào
			guestService.addGuestInfo(new Guest(checkin.getName(), checkin.getBirth(), checkin.getIdCard(),
					checkin.getPassport(), checkin.getAddress(), checkin.getNationality(), checkin.getPhone(),
					checkin.getEmail(), "false", chamber.getIsVip())); // them moi khach
		} else {
			// trường hợp có nhiều khách có cùng id card => sai csdl => báo lỗi về 
			result.setMessage("Lỗi hệ thống vui lòng thử lại sau!");
			return ResponseEntity.badRequest().body(result);
		}
		
		Guest guestCheckExAndCheckInserted = guestService.searchGuestWithCart(checkin.getIdCard());
		// khach quen check-in se lay lai thong tin da co va chen them cot chua co, khach moi check-in se dc them vao
		// csdl

		Rental rental = new Rental();
		Set<Chamber> chambers = new HashSet<Chamber>();
		chambers.add(chamber);
		rental.setChambers(chambers);
		rental.setGuest(guestCheckExAndCheckInserted);
		
		Date date = new Date();
		rental.setCheckInDate(date); // set ngay check in la ngay hom nay
		rental.setNote(checkin.getNote());
		rental.setPaid("false"); // khach chua co tra tien

		rentalService.addRentalInfo(rental); // them hoa don thue phong

		if (guestCheckExAndCheckInserted != null)
			result.setMessage("Check in thành công!");
		return ResponseEntity.ok(result);

	}
}

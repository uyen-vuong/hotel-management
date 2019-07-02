package com.devpro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devpro.spring.model.Guest;
import com.devpro.spring.service.GuestService;;
@Controller
public class GuestController {

	@Autowired
	private GuestService guestService;

	@GetMapping("/guests")
	public String loadListGuests(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {

//		Pageable pageable = PageRequest.of(page, size);
//		
//		model.addAttribute("guests", guestService.findAllGuest(pageable));
		model.addAttribute("guests", guestService.findAll());
		return "guest";
	}

//	@GetMapping("/guests")
//	public ResponseEntity<List<Guest>> getAllGuest(Pageable pageable) {
//		Page<Guest> page = guestService.findAllGuest(pageable);
//		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/guests");
//		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//	}

	@GetMapping("/update-guest-info")
	public String updateGuestInfo(@RequestParam(name = "id") Long guestId,
			@RequestParam(name = "name") String guestName, @RequestParam(name = "card") String idCard,
			@RequestParam(name = "birth") String birth, @RequestParam(name = "passport") String passport,
			@RequestParam(name = "address") String address, @RequestParam(name = "nationality") String nationality,
			@RequestParam(name = "phone") String phoneNumber,
			@RequestParam(name = "vip", required = false, defaultValue = "off") String vip) {

		String isVip = "No";
		if (vip.equalsIgnoreCase("on"))
			isVip = "Yes";
		Guest guest = new Guest(guestId, guestName, birth, idCard, passport, address, nationality, phoneNumber, isVip);
		guestService.editGuestInfo(guest);
		return "redirect:/guests";
	}

}

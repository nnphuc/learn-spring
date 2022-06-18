package com.phucnn.vn.learnspring.web;

import com.phucnn.vn.learnspring.business.ReservationService;
import com.phucnn.vn.learnspring.data.Guest;
import com.phucnn.vn.learnspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;
    public GuestController(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuest(Model model) {
        List<Guest> guestList = reservationService.getHotelGuests();
        model.addAttribute("guests", guestList);
        return "hotel-guest";
    }
}

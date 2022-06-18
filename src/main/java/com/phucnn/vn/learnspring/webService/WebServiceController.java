package com.phucnn.vn.learnspring.webService;

import com.phucnn.vn.learnspring.business.ReservationService;
import com.phucnn.vn.learnspring.business.RoomReservation;
import com.phucnn.vn.learnspring.data.Reservation;
import com.phucnn.vn.learnspring.util.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public WebServiceController(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @RequestMapping(path = "/reservations", method=GET)
    public List<RoomReservation> getReservations(@RequestParam(name="date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        return reservations;
    }
}

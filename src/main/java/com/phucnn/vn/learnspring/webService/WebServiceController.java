package com.phucnn.vn.learnspring.webService;

import com.phucnn.vn.learnspring.business.ReservationService;
import com.phucnn.vn.learnspring.business.RoomReservation;
import com.phucnn.vn.learnspring.data.Guest;
import com.phucnn.vn.learnspring.data.Reservation;
import com.phucnn.vn.learnspring.data.Room;
import com.phucnn.vn.learnspring.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/guests", method=GET)
    public List<Guest> getGuests() {
        List<Guest> guests = this.reservationService.getHotelGuests();
        return guests;
    }

    @RequestMapping(path = "/rooms", method=GET)
    public List<Room> getRooms() {
        List<Room> rooms = this.reservationService.getHotelRooms();
        return rooms;
    }

    @PostMapping(path="/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }
}

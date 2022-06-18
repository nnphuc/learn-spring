package com.phucnn.vn.learnspring.util;

import com.phucnn.vn.learnspring.business.ReservationService;
import com.phucnn.vn.learnspring.business.RoomReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }
}


//@Component
//public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
//    @Autowired
//    private RoomRepository roomRepository;
//    @Autowired
//    private GuestRepository guestRepository;
//    @Autowired
//    private ReservationRepository reservationRepository;
//
//    public AppStartupEvent() {
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Iterable<Room> rooms = roomRepository.findAll();
//        for (Object room : rooms) {
//            System.out.println(room);
//        }
//
//        Iterable<Guest> guests = guestRepository.findAll();
//        for (Object guest : guests) {
//            System.out.println(guest);
//        }
//
//        Iterable<Reservation> reservations = reservationRepository.findAll();
//        for (Reservation reservation : reservations) {
//            System.out.println(reservation);
//        }
//    }
//}

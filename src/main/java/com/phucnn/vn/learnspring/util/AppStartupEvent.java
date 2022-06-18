package com.phucnn.vn.learnspring.util;

import com.phucnn.vn.learnspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        for (Object room : rooms) {
            System.out.println(room);
        }

        Iterable<Guest> guests = guestRepository.findAll();
        for (Object guest : guests) {
            System.out.println(guest);
        }

        Iterable<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

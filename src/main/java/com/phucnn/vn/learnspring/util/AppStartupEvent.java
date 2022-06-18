package com.phucnn.vn.learnspring.util;

import com.phucnn.vn.learnspring.data.Room;
import com.phucnn.vn.learnspring.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;

    public AppStartupEvent(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        for(Room room : rooms) {
            System.out.println(room);
        }
    }
}

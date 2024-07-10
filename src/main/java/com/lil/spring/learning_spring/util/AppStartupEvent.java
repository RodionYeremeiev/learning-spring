package com.lil.spring.learning_spring.util;

import com.lil.spring.learning_spring.data.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
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
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(room -> log.info(String.valueOf(room)));

        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(guest -> log.info(String.valueOf(guest)));

        Iterable<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(reservation -> log.info(String.valueOf(reservation)));
    }
}

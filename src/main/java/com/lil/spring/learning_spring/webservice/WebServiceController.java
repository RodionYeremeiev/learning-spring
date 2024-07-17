package com.lil.spring.learning_spring.webservice;

import com.lil.spring.learning_spring.business.ReservationService;
import com.lil.spring.learning_spring.business.RoomReservation;
import com.lil.spring.learning_spring.data.Guest;
import com.lil.spring.learning_spring.data.Room;
import com.lil.spring.learning_spring.util.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests(){
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        this.reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }

}

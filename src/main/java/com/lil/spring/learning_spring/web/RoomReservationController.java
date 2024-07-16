package com.lil.spring.learning_spring.web;

import com.lil.spring.learning_spring.business.ReservationService;
import com.lil.spring.learning_spring.business.RoomReservation;
import com.lil.spring.learning_spring.util.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
@AllArgsConstructor
public class RoomReservationController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(
            @RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = dateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "roomres";
    }
}

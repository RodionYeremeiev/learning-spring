package com.lil.spring.learning_spring.web;

import com.lil.spring.learning_spring.business.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/guests")
@AllArgsConstructor
public class GuestController {
    private final ReservationService reservationService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        model.addAttribute("guests", this.reservationService.getHotelGuests());
        return "hotel-guests";
    }
}

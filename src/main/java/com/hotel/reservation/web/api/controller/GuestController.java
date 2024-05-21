package com.hotel.reservation.web.api.controller;

import com.hotel.reservation.service.GuestService;
import com.hotel.reservation.service.model.Guest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping
    public List<Guest> getAllGuests(){
        return guestService.findAllGuests();
    }
}

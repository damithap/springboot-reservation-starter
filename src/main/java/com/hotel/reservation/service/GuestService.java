package com.hotel.reservation.service;

import com.hotel.reservation.service.model.Guest;
import com.hotel.reservation.data.repository.GuestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    private ModelMapper modelMapper;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAllGuests() {
        List<com.hotel.reservation.data.entity.Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guest -> modelMapper.map(guest, Guest.class))
                .collect(Collectors.toList());
    }
}

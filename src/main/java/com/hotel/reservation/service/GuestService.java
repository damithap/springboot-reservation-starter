package com.hotel.reservation.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reservation.service.model.Guest;
import com.hotel.reservation.data.repository.GuestRepository;

@Service
@AllArgsConstructor
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Guest> findAllGuests() {
        List<com.hotel.reservation.data.entity.Guest> guests = guestRepository.findAll();
        return guests.stream()
                .map(guest -> modelMapper.map(guest, Guest.class))
                .collect(Collectors.toList());
    }
}

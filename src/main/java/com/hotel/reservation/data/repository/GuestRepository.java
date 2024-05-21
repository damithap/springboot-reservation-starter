package com.hotel.reservation.data.repository;

import com.hotel.reservation.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}

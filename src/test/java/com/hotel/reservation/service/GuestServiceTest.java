package com.hotel.reservation.service;

import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.modelmapper.ModelMapper;

import com.hotel.reservation.data.entity.Guest;
import com.hotel.reservation.data.repository.GuestRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GuestServiceTest {

    @Mock
    private static GuestRepository guestRepository;

    @InjectMocks
    private static GuestService guestService;

    @BeforeAll
    public static void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        guestService = new GuestService(guestRepository, modelMapper);  // Manual injection
    }

    @Test
    public void test_findAllGuests_Success() {
        // prepare test data for mock
        Guest guest = new Guest(1, "john", "doe", "john.doe@email.com", "address", "country", "state", "0000000001") ;
        List<Guest> guests = List.of(guest);
        when(guestRepository.findAll()).thenReturn(guests);

        List<com.hotel.reservation.service.model.Guest> guestsResponse = guestService.findAllGuests();

        assertNotNull(guestsResponse);
        assertEquals("john", guestsResponse.get(0).getFirstName());
    }
}

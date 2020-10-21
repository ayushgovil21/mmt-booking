package com.mmt.services.booking.repositories;


import com.mmt.services.booking.domains.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}

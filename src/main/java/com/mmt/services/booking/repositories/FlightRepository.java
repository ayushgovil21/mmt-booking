package com.mmt.services.booking.repositories;

import com.mmt.services.booking.domains.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer>{
    // JPQL query


    @Query("from Flight where to_destination=:arrivalCity and travel_date=:dateOfDeparture")
    List<Flight> findFlightsToDestination(@Param("arrivalCity") String to,
                             @Param("dateOfDeparture") Date departureDate);

    @Query("from Flight where from_source=:departureCity and travel_date=:dateOfDeparture")
    List<Flight> findFlightsFromSource(@Param("departureCity") String from,
                             @Param("dateOfDeparture") Date departureDate);


}

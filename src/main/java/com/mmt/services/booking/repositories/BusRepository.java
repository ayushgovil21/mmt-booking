package com.mmt.services.booking.repositories;

import com.mmt.services.booking.domains.Bus;
import com.mmt.services.booking.domains.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Integer> {


    @Query("from Bus  where to_destination=:arrivalCity and travel_date=:dateOfDeparture")
    List<Bus> findBusesToDestination(@Param("arrivalCity") String to,
                                          @Param("dateOfDeparture") Date departureDate);

    @Query("from Bus where from_source=:departureCity and travel_date=:dateOfDeparture")
    List<Bus> findBusesFromSource(@Param("departureCity") String from,
                                       @Param("dateOfDeparture") Date departureDate);

}

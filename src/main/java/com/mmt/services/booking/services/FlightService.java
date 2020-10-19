package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.Flight;
import com.mmt.services.booking.domains.FlightPriceList;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<FlightPriceList> findFlights(String source, String destination, Date departDate);
}

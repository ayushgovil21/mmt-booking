package com.mmt.services.booking.services;

import com.mmt.services.booking.controllers.BookingController;
import com.mmt.services.booking.domains.Flight;
import com.mmt.services.booking.domains.FlightPriceList;

import com.mmt.services.booking.repositories.FlightRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private static final Logger LOGGER= LoggerFactory.getLogger(BookingController.class);

    @Autowired
    FlightRepository flightRepository;

    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    @Override
    public List<FlightPriceList> findFlights(String source, String destination, Date departDate) {


        List<Flight> sourceFlightList = flightRepository.findFlightsFromSource(source,departDate);
        List<Flight> destFlightList= flightRepository.findFlightsToDestination(destination,departDate);

        List<FlightPriceList> fpl =new ArrayList<>();
        final Map<String,Flight> destMp = new HashMap<>();
        sourceFlightList.forEach(src->{
            if(!src.getTo_destination().equals(destination))
            {
                destMp.put(src.getTo_destination(),src);
            }
            else
            {
                FlightPriceList flightPriceList = new FlightPriceList();
                List<Flight> flights = new ArrayList<>();
                flightPriceList.setFare(src.getFare());
                flights.add(src);
                flightPriceList.setFlights(flights);
                fpl.add(flightPriceList);
            }

        });

        destFlightList.forEach(dest->{
            if(destMp.containsKey(dest.getFrom_source()))
            {
                Date firstFlightDate = new Date(destMp.get(dest.getFrom_source()).getStart_time().getTime());
                FlightPriceList flightPriceList = new FlightPriceList();
                Date dateWithDuration=new Date(firstFlightDate.getTime() + (dest.getDuration() * ONE_MINUTE_IN_MILLIS));
                Date dateToReach = new Date(dest.getStart_time().getTime());

                if(dateWithDuration.compareTo(dateToReach)<0) {
                    List<Flight> flights = new ArrayList<>();
                    flightPriceList.setFare(dest.getFare() + destMp.get(dest.getFrom_source()).getFare());
                    flights.add(destMp.get(dest.getFrom_source()));
                    flights.add(dest);
                    flightPriceList.setFlights(flights);
                    fpl.add(flightPriceList);
                }
            }
        });

        return fpl.stream().sorted(Comparator.comparing(FlightPriceList::getFare)).collect(Collectors.toList());
    }
}
package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.Flight;
import com.mmt.services.booking.domains.FlightPriceList;

import com.mmt.services.booking.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<FlightPriceList> findFlights(String source, String destination, Date departDate) {


        List<Flight> sourceFlightList = flightRepository.findFlightsFromSource(source,departDate);
        List<Flight> destFlightList= flightRepository.findFlightsToDestination(destination,departDate);

        List<FlightPriceList> fpl =new ArrayList<>();
        final Map<String,Flight> destMp = new HashMap<>();
        sourceFlightList.stream().forEach(src->{
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

        destFlightList.stream().forEach(dest->{
            if(destMp.containsKey(dest.getFrom_source()))
            {
                FlightPriceList flightPriceList = new FlightPriceList();
                List<Flight> flights = new ArrayList<>();
                flightPriceList.setFare(dest.getFare()+destMp.get(dest.getFrom_source()).getFare());
                flights.add(destMp.get(dest.getFrom_source()));
                flights.add(dest);
                flightPriceList.setFlights(flights);
                fpl.add(flightPriceList);
            }
        });


        Collections.sort(fpl);
        return fpl;

    }
}
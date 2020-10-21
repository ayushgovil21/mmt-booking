package com.mmt.services.booking.controllers;

import com.mmt.services.booking.domains.*;
import com.mmt.services.booking.repositories.BookingRepository;
import com.mmt.services.booking.repositories.BusRepository;
import com.mmt.services.booking.services.BusService;
import com.mmt.services.booking.services.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    FlightService flightService;

    @Autowired
    BusService busService;

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping("/findBookings")
    public BookingDetails findBooking(@RequestParam("source") String source, @RequestParam("destination") String destination,
                                      @RequestParam("departDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departDate) {

        LOGGER.info("Inside BookingFlights() From:" + source + " TO:" + destination + "Departure Date: " + departDate);
        List<FlightPriceList> flights = flightService.findFlights(source, destination, departDate);
        List<BusPriceList> buses = busService.findBuses(source, destination, departDate);
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFlights(flights);
        bookingDetails.setBuses(buses);

        LOGGER.info("Flights found are" + flights.toString());
        LOGGER.info("Buses found are" + buses.toString());

        return bookingDetails;
    }

    @PostMapping("/addBookings")
    public Booking addBooking(@RequestBody Passenger passenger, @RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("flightId") int flightId, @RequestParam("busId") int busId,
                              @RequestParam("departDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departDate) {

        LOGGER.info("Inside BookingFlights() From:" + source + " TO:" + destination + "Departure Date: " + departDate);

        Passenger passengerObj = new Passenger(passenger.getPassengerId(), passenger.getEmailId(), passenger.getFirstName(), passenger.getLastName());
        Booking bookingObj = new Booking(passengerObj.getPassengerId(), source, destination, flightId, busId, FlightStatus.BOOKED, BusStatus.BOOKED);
        LOGGER.info("Booking Object " + bookingObj);
        bookingRepository.save(bookingObj);

        return bookingObj;

    }
}

package com.mmt.services.booking.test;

import com.mmt.services.booking.controllers.BookingController;
import com.mmt.services.booking.domains.BookingDetails;
import com.mmt.services.booking.domains.Flight;
import com.mmt.services.booking.domains.FlightPriceList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @MockBean
    private BookingController bookingController;

    @Test
    public void findBooking() throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = dateFormat.parse("2020-10-18");
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        BookingDetails bookingDetails = new BookingDetails();
        List<Flight> flights = new ArrayList<>();
        List<FlightPriceList> flightPriceLists = new ArrayList<>();

        FlightPriceList flightPriceList = new FlightPriceList(flights, 1500);
        Flight flight = new Flight(1, "HYDERABAD", "BENGALURU", date, 80, 1550, timestamp);

        flights.add(flight);
        flightPriceLists.add(flightPriceList);

        bookingDetails.setFlights(flightPriceLists);

        BDDMockito.given(bookingController.findBooking("HYDERABAD", "BENGALURU", date)).willReturn(bookingDetails);
    }
}
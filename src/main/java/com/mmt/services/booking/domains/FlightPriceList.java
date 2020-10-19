package com.mmt.services.booking.domains;

import org.springframework.lang.NonNull;

import java.util.List;

public class FlightPriceList implements Comparable<FlightPriceList>{
   private List<Flight> flights;
   private double fare;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "FlightPriceList{" +
                "flights=" + flights +
                ", fare=" + fare +
                '}';
    }

        @Override
        public int compareTo(@NonNull FlightPriceList flightPriceList) {
            return this.fare < flightPriceList.getFare() ?1 : 0;
        }
}

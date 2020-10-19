package com.mmt.services.booking.domains;

import java.util.List;

public class BookingDetails {
    private List<FlightPriceList> flights;
    private List<BusPriceList> buses;

    public List<FlightPriceList> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightPriceList> flights) {
        this.flights = flights;
    }

    public List<BusPriceList> getBuses() {
        return buses;
    }

    public void setBuses(List<BusPriceList> buses) {
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "flights=" + flights +
                ", buses=" + buses +
                '}';
    }
}

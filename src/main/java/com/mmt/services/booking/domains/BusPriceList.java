package com.mmt.services.booking.domains;

import org.springframework.lang.NonNull;

import java.util.List;

public class BusPriceList implements Comparable<BusPriceList>{
    private List<Bus> buses;
    private double fare;

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }


    @Override
    public String toString() {
        return "BusPriceList{" +
                "buses=" + buses +
                ", fare=" + fare +
                '}';
    }

    @Override
    public int compareTo(@NonNull BusPriceList busPriceList) {
        return this.fare > busPriceList.getFare() ?1 : 0;
    }
}

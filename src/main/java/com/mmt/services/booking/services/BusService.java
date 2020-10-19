package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.BusPriceList;

import java.util.Date;
import java.util.List;

public interface BusService {
    List<BusPriceList> findBuses(String source, String destination, Date departDate);
}

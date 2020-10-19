package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.Bus;
import com.mmt.services.booking.domains.BusPriceList;
import com.mmt.services.booking.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public List<BusPriceList> findBuses(String source, String destination, Date departDate) {
        List<Bus> sourceBusList = busRepository.findBusesFromSource(source,departDate);
        List<Bus> destBusList= busRepository.findBusesToDestination(destination,departDate);

        List<BusPriceList> bpl =new ArrayList<>();
        final Map<String,Bus> destMp = new HashMap<>();
        sourceBusList.stream().forEach(src->{
            if(!src.getTo_destination().equals(destination))
            {
                destMp.put(src.getTo_destination(),src);
            }
            else
            {
                BusPriceList busPriceList = new BusPriceList();
                List<Bus> buses = new ArrayList<>();
                busPriceList.setFare(src.getFare());
                buses.add(src);
                busPriceList.setFlights(buses);
                bpl.add(busPriceList);
            }

        });

        destBusList.stream().forEach(dest->{
            if(destMp.containsKey(dest.getFrom_source()))
            {
                BusPriceList busPriceList = new BusPriceList();
                List<Bus> buses = new ArrayList<>();
                busPriceList.setFare(dest.getFare()+destMp.get(dest.getFrom_source()).getFare());
                buses.add(destMp.get(dest.getFrom_source()));
                buses.add(dest);
                busPriceList.setFlights(buses);
                bpl.add(busPriceList);
            }
        });


        Collections.sort(bpl);
        return bpl;
    }
}

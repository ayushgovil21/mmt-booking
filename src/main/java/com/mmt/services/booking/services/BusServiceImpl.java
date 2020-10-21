package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.Bus;
import com.mmt.services.booking.domains.BusPriceList;
import com.mmt.services.booking.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    @Override
    public List<BusPriceList> findBuses(String source, String destination, Date departDate) {
        List<Bus> sourceBusList = busRepository.findBusesFromSource(source,departDate);
        List<Bus> destBusList= busRepository.findBusesToDestination(destination,departDate);

        List<BusPriceList> bpl =new ArrayList<>();
        final Map<String,Bus> destMp = new HashMap<>();
        sourceBusList.stream().forEach(src->{
            if(!src.getToDestination().equals(destination))
            {
                destMp.put(src.getToDestination(),src);
            }
            else
            {
                BusPriceList busPriceList = new BusPriceList();
                List<Bus> buses = new ArrayList<>();
                busPriceList.setFare(src.getFare());
                buses.add(src);
                busPriceList.setBuses(buses);
                bpl.add(busPriceList);
            }

        });

        destBusList.stream().forEach(dest->{
            if(destMp.containsKey(dest.getFromSource()))
            {
                Date firstBusDate = new Date(destMp.get(dest.getFromSource()).getStartTime().getTime());
                BusPriceList busPriceList = new BusPriceList();
                Date dateWithDuration=new Date(firstBusDate.getTime() + (dest.getDuration() * ONE_MINUTE_IN_MILLIS));
                Date dateToReach = new Date(dest.getStartTime().getTime());

                if(dateWithDuration.compareTo(dateToReach)<0) {
                    List<Bus> buses = new ArrayList<>();
                    busPriceList.setFare(dest.getFare() + destMp.get(dest.getFromSource()).getFare());
                    buses.add(destMp.get(dest.getFromSource()));
                    buses.add(dest);
                    busPriceList.setBuses(buses);
                    bpl.add(busPriceList);
                }
            }
        });

        return bpl.stream().sorted(Comparator.comparing(BusPriceList::getFare)).collect(Collectors.toList());
    }
}

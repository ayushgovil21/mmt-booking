package com.mmt.services.booking.services;

import com.mmt.services.booking.domains.Bus;
import com.mmt.services.booking.domains.BusPriceList;
import com.mmt.services.booking.domains.FlightPriceList;
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
                busPriceList.setBuses(buses);
                bpl.add(busPriceList);
            }

        });

        destBusList.stream().forEach(dest->{
            if(destMp.containsKey(dest.getFrom_source()))
            {
                Date firstBusDate = new Date(destMp.get(dest.getFrom_source()).getStart_time().getTime());
                BusPriceList busPriceList = new BusPriceList();
                Date dateWithDuration=new Date(firstBusDate.getTime() + (dest.getDuration() * ONE_MINUTE_IN_MILLIS));
                Date dateToReach = new Date(dest.getStart_time().getTime());

                if(dateWithDuration.compareTo(dateToReach)<0) {
                    List<Bus> buses = new ArrayList<>();
                    busPriceList.setFare(dest.getFare() + destMp.get(dest.getFrom_source()).getFare());
                    buses.add(destMp.get(dest.getFrom_source()));
                    buses.add(dest);
                    busPriceList.setBuses(buses);
                    bpl.add(busPriceList);
                }
            }
        });

        return bpl.stream().sorted(Comparator.comparing(BusPriceList::getFare)).collect(Collectors.toList());
    }
}

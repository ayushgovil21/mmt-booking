package com.mmt.services.booking.domains;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Bus")
public class Bus{

    @Column
    @Id
    private int bus_id;
    @Column
    private String from_source;
    @Column
    private String to_destination;
    @Column
    @Temporal(TemporalType.DATE)
    private Date travel_date;
    @Column
    private int duration;
    @Column
    private double fare;
    @Column
    private Timestamp start_time;

    public String getFrom_source() {
        return from_source;
    }

    public void setFrom_source(String from_source) {
        this.from_source = from_source;
    }

    public String getTo_destination() {
        return to_destination;
    }

    public void setTo_destination(String to_destination) {
        this.to_destination = to_destination;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public Date getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(Date travel_date) {
        this.travel_date = travel_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "bus_id='" + bus_id + '\'' +
                ", from_source='" + from_source + '\'' +
                ", to_destination='" + to_destination + '\'' +
                ", travel_date=" + travel_date +
                ", duration=" + duration +
                ", fare=" + fare +
                ", start_time=" + start_time +
                '}';
    }
}

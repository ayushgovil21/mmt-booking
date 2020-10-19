package com.mmt.services.booking.domains;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Flight")
public class Flight {

    @Column
    @Id
    private int flight_id;

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

    public Flight() {
    }

    public Flight(int flight_id, String from_source, String to_destination, Date travel_date, int duration, double fare, Timestamp start_time) {
        this.flight_id = flight_id;
        this.from_source = from_source;
        this.to_destination = to_destination;
        this.travel_date = travel_date;
        this.duration = duration;
        this.fare = fare;
        this.start_time = start_time;
    }

    public Flight(int i, String hyderabad, String bengaluru, String s, int i1, int i2, String s1, int i3) {
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

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

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id='" + flight_id + '\'' +
                ", from_source='" + from_source + '\'' +
                ", to_destination='" + to_destination + '\'' +
                ", travel_date=" + travel_date +
                ", duration=" + duration +
                ", fare=" + fare +
                ", start_time=" + start_time +
                '}';
    }
}

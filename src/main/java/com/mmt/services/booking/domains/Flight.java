package com.mmt.services.booking.domains;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Flight")
public class Flight {

    @Column
    @Id
    private int flightId;

    @Column
    private String fromSource;

    @Column
    private String toDestination;

    @Column
    @Temporal(TemporalType.DATE)
    private Date travelDate;
    @Column
    private int duration;
    @Column
    private double fare;
    @Column
    private Timestamp startTime;

    public Flight() {
    }

    public Flight(int flightId, String fromSource, String toDestination, Date travelDate, int duration, double fare, Timestamp startTime) {
        this.flightId = flightId;
        this.fromSource = fromSource;
        this.toDestination = toDestination;
        this.travelDate = travelDate;
        this.duration = duration;
        this.fare = fare;
        this.startTime = startTime;
    }

    public Flight(int i, String hyderabad, String bengaluru, String s, int i1, int i2, String s1, int i3) {
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id='" + flightId + '\'' +
                ", from_source='" + fromSource + '\'' +
                ", to_destination='" + toDestination + '\'' +
                ", travel_date=" + travelDate +
                ", duration=" + duration +
                ", fare=" + fare +
                ", start_time=" + startTime +
                '}';
    }
}

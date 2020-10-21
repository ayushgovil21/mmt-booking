package com.mmt.services.booking.domains;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Bus")
public class Bus{

    @Column
    @Id
    private int busId;
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

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "bus_id='" + busId + '\'' +
                ", from_source='" + fromSource + '\'' +
                ", to_destination='" + toDestination + '\'' +
                ", travel_date=" + travelDate +
                ", duration=" + duration +
                ", fare=" + fare +
                ", start_time=" + startTime +
                '}';
    }
}

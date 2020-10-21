package com.mmt.services.booking.domains;

import javax.persistence.*;

@Entity
@Table(name="Booking")
public class Booking {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int bookingId;

    @JoinColumn(name="passengerId",insertable = false,updatable = false)
    private int passengerId;

    @Column
    private String fromSource;

    @Column
    private String toDestination;

    @JoinColumn(name="flightId",insertable = false,updatable = false)
    private int flightId;

    @JoinColumn(name="busId",insertable = false,updatable = false)
    private int busId;

    private FlightStatus flightStatus;

    private BusStatus busStatus;

    public Booking() {
    }

    public Booking(int passengerId, String fromSource, String toDestination, int flightId, int busId, FlightStatus flightStatus, BusStatus busStatus) {
        this.passengerId = passengerId;
        this.fromSource = fromSource;
        this.toDestination = toDestination;
        this.flightId = flightId;
        this.busId = busId;
        this.flightStatus = flightStatus;
        this.busStatus = busStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
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

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public BusStatus getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(BusStatus busStatus) {
        this.busStatus = busStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", passengerId=" + passengerId +
                ", fromSource='" + fromSource + '\'' +
                ", toDestination='" + toDestination + '\'' +
                ", flightId=" + flightId +
                ", busId=" + busId +
                ", flightStatus=" + flightStatus +
                ", busStatus=" + busStatus +
                '}';
    }
}

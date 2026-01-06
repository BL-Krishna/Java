package com.cabinvoice;

public class Ride {
    public final RideType rideType;
    public final double distance;
    public final int time;

    public Ride(RideType rideType, double distance, int time) {
        this.rideType = rideType;
        this.distance = distance;
        this.time = time;
    }
}

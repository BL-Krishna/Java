package com.cabinvoice;

public class CabInvoiceGenerator {

    public double calculateFare(RideType rideType, double distance, int time) {
        double fare = distance * rideType.costPerKm + time * rideType.costPerMinute;
        return Math.max(fare, rideType.minimumFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.rideType, ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}

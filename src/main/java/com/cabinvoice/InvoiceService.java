package com.cabinvoice;

public class InvoiceService {

    private final RideRepository rideRepository = new RideRepository();
    private final CabInvoiceGenerator generator = new CabInvoiceGenerator();

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoice(String userId) {
        return generator.calculateFare(rideRepository.getRides(userId));
    }
}

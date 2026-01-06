package com.cabinvoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {

    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double fare = generator.calculateFare(RideType.NORMAL, 2.0, 5);
        assertEquals(25.0, fare);
    }

    @Test
    void givenMultipleRides_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = {
                new Ride(RideType.NORMAL, 2.0, 5),
                new Ride(RideType.NORMAL, 0.1, 1)
        };

        InvoiceSummary summary = generator.calculateFare(rides);

        assertEquals(2, summary.getTotalRides());
        assertEquals(30.0, summary.getTotalFare());
        assertEquals(15.0, summary.getAverageFare());
    }

    @Test
    void givenPremiumRide_ShouldReturnPremiumFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double fare = generator.calculateFare(RideType.PREMIUM, 2.0, 5);
        assertEquals(40.0, fare);
    }
}

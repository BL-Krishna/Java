package com.cabinvoice;

public class InvoiceSummary {
    private final int totalRides;
    private final double totalFare;

    public InvoiceSummary(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return totalFare / totalRides;
    }
}

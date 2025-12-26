package com.hotelreservation;

import java.time.LocalDate;

public class HotelReservation {
   public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program ");
       HotelReservationService service =new HotelReservationService();

       CustomerType customerType=CustomerType.REWARDS;

        LocalDate startDate=DateUtil.parseDate("26122025");
        LocalDate endDate=DateUtil.parseDate("27122025");

        Hotel cheapsetHotel=service.findCheapestBestRatedHotel(customerType,startDate,endDate);
        int totalRate=service.getTotalRate(cheapsetHotel,customerType,startDate,endDate);

        System.out.println("Cheapest Hotel:"+cheapsetHotel.getName());
        System.out.println("Rating:"+cheapsetHotel.getRating());
        System.out.println("Total Rates: $"+totalRate);

    }
}

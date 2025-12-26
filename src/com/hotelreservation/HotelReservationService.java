package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class HotelReservationService {

    private final List<Hotel> hotels=new ArrayList<>();

    public HotelReservationService(){
        hotels.add(new Hotel("Lakewood",3,new Rate(90,110),new Rate(80,80)));
        hotels.add(new Hotel("Hotel Taj",3,new Rate(160,200),new Rate(110,50)));
        hotels.add(new Hotel("K Hotel",3,new Rate(180,200),new Rate(100,40)));


    }

    //uc 10 & 11 -using Java Streams

    public Hotel findCheapestBestRatedHotel(CustomerType customerType, LocalDate startDate,LocalDate endDate){
        return hotels.stream()
                .min(Comparator.comparingInt((Hotel h)->h.calculateTotalRate(customerType,startDate,endDate))
                .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .orElseThrow(()->new InvalidInputException("No hotels available"));

    }

    public int getTotalRate(Hotel hotel,CustomerType customerType,LocalDate startDate,LocalDate endDate){
        return hotel.calculateTotalRate(customerType,startDate,endDate);
    }





}

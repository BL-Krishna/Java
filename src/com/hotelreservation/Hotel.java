package com.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
    private String name;
    private int rating;
    private Rate regularRate;
    private  Rate rewardRate;

    public Hotel(String name, int rating, Rate regularRate, Rate rewardRate) {
        this.name = name;
        this.rating = rating;
        this.regularRate = regularRate;
        this.rewardRate = rewardRate;
    }
    public String getName(){
        return name;

    }
    public int getRating(){
        return rating;
    }

    public int calculateTotalRate(CustomerType customerType,
                                  LocalDate startDate,
                                  LocalDate endDate) {

        int total = 0;
        Rate rate = (customerType == CustomerType.REGULAR)
                ? regularRate
                : rewardRate;

        for (LocalDate date = startDate;
             !date.isAfter(endDate);
             date = date.plusDays(1)) {

            boolean isWeekend =
                    date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                            date.getDayOfWeek() == DayOfWeek.SUNDAY;

            total += isWeekend
                    ? rate.getWeekendRate()
                    : rate.getWeekdayRate();
        }
        return total;
    }

}

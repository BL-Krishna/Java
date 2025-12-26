package com.hotelreservation;

public class Rate {
    private int weekdayRate;
    private int weekendRate;

    public Rate(int weekdayRate,int weekendRate){
        this.weekdayRate=weekdayRate;
        this.weekendRate=weekendRate;
    }
    public int getWeekdayRate(){
        return weekdayRate;
    }
    public int getWeekendRate(){
        return weekendRate;
    }
}

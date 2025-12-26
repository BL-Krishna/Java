package com.hotelreservation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH);

    public static LocalDate parseDate(String date){
        try{
            return LocalDate.parse(date,FORMATTER);
        }catch (Exception e){
            throw new InvalidInputException("Invalid date format . Expected format: ddMMyyyy");
        }
    }
}

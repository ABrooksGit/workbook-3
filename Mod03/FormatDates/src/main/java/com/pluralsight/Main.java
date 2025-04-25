package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        DateTimeFormatter od = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = date.format(od);
        System.out.println(formattedDate);
        //System.out.println(today.getMonthValue() + "/" + today.getDayOfMonth() + "/" + today.getYear());
        System.out.println(today.getYear() + "-" + today.getMonthValue() + "-" + today.getDayOfMonth());
        System.out.println(today.getMonth() + " "+ today.getDayOfMonth() + " " + today.getYear());
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm");
        String formattedDate2 = today.format(fmt);
        System.out.println(formattedDate2);

    }
}

//        LocalDateTime rightNow = LocalDateTime.now();
//        System.out.println(today);
//        System.out.println(time);
//        System.out.println(rightNow);
//        System.out.println(today.getDayOfWeek());
//        System.out.println(today.getMonthValue());
//        System.out.println(today.getMonth());
//        System.out.println(today.getDayOfMonth());
//        System.out.println(today.getDayOfYear());
//        System.out.println(today.getYear());
//        System.out.println(today.getEra());
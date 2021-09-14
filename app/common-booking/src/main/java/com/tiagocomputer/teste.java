package com.tiagocomputer;

import java.time.LocalDate;

public class teste {

    public static void main(String[] args) {
        LocalDate bookingDay = LocalDate.now();
        LocalDate bookingStart = LocalDate.now();
        LocalDate bookingEnd = LocalDate.now();

        LocalDate startPlus30Day = bookingStart.plusDays(29);
        LocalDate plus30Days = bookingDay.plusDays(30);

        LocalDate startPlusThreeDay = bookingStart.plusDays(3);
        LocalDate endPlusThreeDay = bookingEnd.plusDays(3);

        Boolean avaible = false;
//        LocalDate start = bookingStart;
        System.out.println("\nBookingStart : " + startPlus30Day + "\nBookingDay: " + bookingDay +
                "\nendPlusThreeDay: " + endPlusThreeDay + "\nstartPlusThreeDay: " + bookingStart);
        if (startPlus30Day.isBefore(plus30Days) && endPlusThreeDay.isBefore(startPlusThreeDay)) {
            avaible = true;
            System.out.println("Can book " + "avaible: " + avaible);
        } else {
            System.out.println("Can't book" + " avaible: " + avaible);
        }


//        System.out.println(plus30Days);
    }
}

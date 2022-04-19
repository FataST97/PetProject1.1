package com.griddynamics.qa.course.service;

import java.time.LocalDateTime;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class TimeCalculation {

    public LocalDateTime calculateEndDate(LocalDateTime startDate, int duration) {
        LocalDateTime temporaryDate = startDate;
        int numOfDays = (int) Math.ceil(duration / 8.0);
        for (int i = 0; i < numOfDays; i++) {
            if (temporaryDate.getDayOfWeek() == SUNDAY
                    | temporaryDate.getDayOfWeek() == SATURDAY) {
                numOfDays++;
            }
            temporaryDate = temporaryDate.plusDays(1);
        }
        LocalDateTime endDate = startDate.plusDays(numOfDays - 1);
        int howMuchHoursIsLeft = duration % 8;
        if (howMuchHoursIsLeft == 0) {
            endDate = endDate.plusHours(8);
        } else endDate = endDate.plusHours(howMuchHoursIsLeft);
        return endDate;
    }

    public int[] calculateHowMuchTimeIsLeft(LocalDateTime presentDate, LocalDateTime endDate) {
        int daysLeft = Math.abs(presentDate.getDayOfMonth() - endDate.getDayOfMonth());
        int hoursLeft = Math.abs(presentDate.getHour() - endDate.getHour());
        return new int[]{daysLeft, hoursLeft};
    }

    public boolean isFinished(LocalDateTime presentDate, LocalDateTime endDate) {
        return presentDate.isAfter(endDate);
    }

}

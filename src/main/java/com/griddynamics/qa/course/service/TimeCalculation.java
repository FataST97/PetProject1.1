package com.griddynamics.qa.course.service;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class TimeCalculation {

    public LocalDateTime calculateEndDate(LocalDateTime startDate, Duration duration) {
        LocalDateTime temporaryDate = startDate;
        int numOfDays = (int) Math.ceil(duration.toHours() / 8.0);
        for (int i = 0; i < numOfDays; i++) {
            if (temporaryDate.getDayOfWeek() == SUNDAY
                    | temporaryDate.getDayOfWeek() == SATURDAY) {
                numOfDays++;
            }
            temporaryDate = temporaryDate.plusDays(1);
        }
        LocalDateTime endDate = startDate.plusDays(numOfDays - 1);
        long howMuchHoursIsLeft = duration.toHours() % 8;
        if (howMuchHoursIsLeft == 0) {
            endDate = endDate.plusHours(8);
        } else endDate = endDate.plusHours(howMuchHoursIsLeft);
        return endDate;
    }

    public Duration calculateHoursLeft(LocalDateTime presentDate, LocalDateTime endDate) {
        return Duration.between(presentDate,endDate);
    }

    public boolean isFinished(LocalDateTime presentDate, LocalDateTime endDate) {
        return presentDate.isAfter(endDate);
    }
}

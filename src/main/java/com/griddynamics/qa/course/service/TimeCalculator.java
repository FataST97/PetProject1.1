package com.griddynamics.qa.course.service;

import com.griddynamics.qa.course.model.Course;
import com.griddynamics.qa.course.model.Student;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class TimeCalculation {

    private static final LocalDateTime PRESENT_DATE = LocalDateTime.of(2020, 6, 8, 15, 0);

    protected Duration calculateDuration(Student student) {
        List<Course> course = student.getCourse();
        return course.get(0).getDuration().plus(
                course.get(1).getDuration()).plus(course.get(2).getDuration());
    }

    public LocalDateTime calculateEndDate(Student student) {
        LocalDateTime temporaryDate = student.getStartDate();
        Duration duration = calculateDuration(student);
        long numOfDays = (long) Math.ceil(duration.toHours() / 8.0);
        for (int i = 0; i < numOfDays; i++) {
            if (temporaryDate.getDayOfWeek() == SUNDAY
                    || temporaryDate.getDayOfWeek() == SATURDAY) {
                numOfDays++;
            }
            temporaryDate = temporaryDate.plusDays(1);
        }
        LocalDateTime endDate = student.getStartDate().plusDays(numOfDays - 1);
        long timeLeft = duration.toHours() % 8;
        if (timeLeft == 0) {
            endDate = endDate.plusHours(8);
        } else endDate = endDate.plusHours(timeLeft);
        return endDate;
    }

    public Duration calculateHoursLeft(Student student) {
        return Duration.between(PRESENT_DATE, calculateEndDate(student));
    }

    public boolean isFinished(Student student) {
        return PRESENT_DATE.isAfter(calculateEndDate(student));
    }
}

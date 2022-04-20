package com.griddynamics.qa.course.model;

import com.griddynamics.qa.course.service.TimeCalculation;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class Student {
    TimeCalculation timeCalculation = new TimeCalculation();
    LocalDateTime presentDate = LocalDateTime.of(2020, 6, 8, 15, 0);
    private String name;
    private LocalDateTime startDate;
    private String curriculumName;
    private Duration durationOfStudying;
    private LocalDateTime endDate;
    private Duration hoursLeft;
    private String courseHoursText;

    Student(String name,LocalDateTime startDate, String curriculumName, Duration durationOfStudying, String courseHoursText){
        this.name = name;
        this.startDate = startDate;
        this.curriculumName = curriculumName;
        this.durationOfStudying = durationOfStudying;
        this.courseHoursText = courseHoursText;
        endDate = timeCalculation.calculateEndDate(startDate, getDurationOfStudying());
        hoursLeft = timeCalculation.
                calculateHoursLeft(presentDate, endDate);

    }
}

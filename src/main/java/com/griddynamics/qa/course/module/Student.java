package com.griddynamics.qa.course.module;

import com.griddynamics.qa.course.service.TimeCalculation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Student {
    TimeCalculation timeCalculation = new TimeCalculation();

    private String name;
    private String CurriculumName;
    private int durationOfStudying;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int[] howMuchTimeIsLeft;
    private String courseHoursText;

}

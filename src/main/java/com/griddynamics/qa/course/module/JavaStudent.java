package com.griddynamics.qa.course.module;

import java.time.LocalDateTime;

import static com.griddynamics.qa.course.module.Hours.*;

public class JavaStudent extends Student {

    public JavaStudent(String name, LocalDateTime startDate){
        super.setName(name);
        super.setCurriculumName("Java Developer");
        super.setStartDate(startDate);
        super.setDurationOfStudying(JAVA.getHours() + JDBC.getHours() +Hours.SPRING.getHours());
        super.setEndDate(timeCalculation.calculateEndDate(startDate, getDurationOfStudying()));
        super.setHowMuchTimeIsLeft(timeCalculation.
                calculateHowMuchTimeIsLeft(LocalDateTime.of(2020, 6, 8, 15, 0), getEndDate()));
        super.setCourseHoursText("\n"+JAVA.getCourseName() + " " + PAGE_OBJECT.getHours() + " hours" +
                "\n"+JDBC.getCourseName() + " " + JDBC.getHours() + " hours" +
                "\n"+SPRING.getCourseName() + " " + SPRING.getHours() + " hours");
    }
}

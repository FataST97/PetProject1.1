package com.griddynamics.qa.course.model;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.griddynamics.qa.course.model.Course.*;

public class JavaStudent extends Student {
    private static final String curriculumName = "Java Developer";
    private static final Duration durationOfStudying =
            JAVA.getDuration().plus(JDBC.getDuration()).plus(SPRING.getDuration());
    private static final String courseHoursText = "\n"+JAVA.getCourseName() + " " + PAGE_OBJECT.getDuration().toHours() + " hours" +
            "\n"+JDBC.getCourseName() + " " + JDBC.getDuration().toHours() + " hours" +
            "\n"+SPRING.getCourseName() + " " + SPRING.getDuration().toHours() + " hours";

    public JavaStudent(String name, LocalDateTime startDate){
        super(name,startDate,curriculumName,durationOfStudying,courseHoursText);
    }
}

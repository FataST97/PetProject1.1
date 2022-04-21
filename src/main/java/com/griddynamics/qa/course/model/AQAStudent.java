package com.griddynamics.qa.course.model;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.griddynamics.qa.course.model.Course.*;

public class AQAStudent extends Student {
    private static final String CURRICULUM_NAME = "J2EE Developer";
    private static final Duration durationOfStudying =
            TEST_DESIGN.getDuration().plus(PAGE_OBJECT.getDuration()).plus(SELENIUM.getDuration());
    private static final String COURSE_HOURS_TEXT = "\n" + TEST_DESIGN.getCourseName() + " " + TEST_DESIGN.getDuration().toHours() + " hours" +
            "\n" + PAGE_OBJECT.getCourseName() + " " + PAGE_OBJECT.getDuration().toHours() + " hours" +
            "\n" + SELENIUM.getCourseName() + " " + SELENIUM.getDuration().toHours() + " hours.";

    public AQAStudent(String name, LocalDateTime startDate) {
        super(name,startDate, CURRICULUM_NAME,durationOfStudying, COURSE_HOURS_TEXT);
    }
}

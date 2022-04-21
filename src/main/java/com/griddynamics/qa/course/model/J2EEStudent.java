package com.griddynamics.qa.course.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.griddynamics.qa.course.model.Course.*;

public class J2EEStudent extends Student {
    private static final String CURRICULUM_NAME = "J2EE Developer";
    private static final List<Course> AQA_COURSES = Arrays.asList(TEST_DESIGN, SELENIUM, PAGE_OBJECT);

    public J2EEStudent(String name, LocalDateTime startDate) {
        super(name, startDate, CURRICULUM_NAME, AQA_COURSES);
    }
}

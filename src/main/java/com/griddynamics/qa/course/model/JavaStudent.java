package com.griddynamics.qa.course.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.griddynamics.qa.course.model.Course.*;

public class JavaStudent extends Student {

    private static final String CURRICULUM_NAME = "Java Developer";
    private static final List<Course> JAVA_COURSES = Arrays.asList(JAVA, JDBC, SPRING);

    public JavaStudent(String name, LocalDateTime startDate) {
        super(name, startDate, CURRICULUM_NAME, JAVA_COURSES);
    }
}

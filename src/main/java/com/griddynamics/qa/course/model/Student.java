package com.griddynamics.qa.course.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Student {

    private final String name;
    private final LocalDateTime startDate;
    private final String curriculumName;
    private final List<Course> course;

}


package com.griddynamics.qa.course.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Student {
    private String name;
    private LocalDateTime startDate;
    private String curriculumName;
    private List<Course> course;

    Student(String name, LocalDateTime startDate, String curriculumName, List<Course> course) {
        this.name = name;
        this.startDate = startDate;
        this.curriculumName = curriculumName;
        this.course = course;
    }
}

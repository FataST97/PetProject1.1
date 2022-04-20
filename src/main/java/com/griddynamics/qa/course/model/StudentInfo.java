package com.griddynamics.qa.course.model;

import java.time.LocalDateTime;

public enum StudentInfo {
    Ivanov_Ivan("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)),
    Sidorov_Ivan("Sidorov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0));
    final LocalDateTime startDate;
    final String studentName;

    public String getStudentName(){return studentName;};
    public LocalDateTime getStartDate(){return startDate;}


    StudentInfo(String studentName, LocalDateTime startDate){
        this.studentName = studentName;
        this.startDate = startDate;
    }
}

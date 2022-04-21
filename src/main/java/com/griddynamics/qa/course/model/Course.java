package com.griddynamics.qa.course.model;

import lombok.Getter;

import java.time.Duration;

public enum Course {

    JAVA("Java", Duration.ofHours(16)),
    JDBC("JDBC", Duration.ofHours(24)),
    SPRING("Spring", Duration.ofHours(16)),
    TEST_DESIGN("Test Design", Duration.ofHours(10)),
    PAGE_OBJECT("Page Object", Duration.ofHours(16)),
    SELENIUM("Selenium", Duration.ofHours(16));

    @Getter
    private final Duration duration;
    @Getter
    private final String courseName;

    Course(String courseName, Duration duration) {
        this.duration = duration;
        this.courseName = courseName;
    }
}

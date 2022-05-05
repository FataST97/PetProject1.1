package com.griddynamics.qa.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public enum Course {

    JAVA("Java", Duration.ofHours(16)),
    JDBC("JDBC", Duration.ofHours(24)),
    SPRING("Spring", Duration.ofHours(16)),
    TEST_DESIGN("Test Design", Duration.ofHours(10)),
    PAGE_OBJECT("Page Object", Duration.ofHours(16)),
    SELENIUM("Selenium", Duration.ofHours(16));

    private final String courseName;
    private final Duration duration;

}

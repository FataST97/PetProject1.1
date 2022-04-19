package com.griddynamics.qa.course.module;

import lombok.Getter;

public enum Hours {

    JAVA("Java", 16),
    JDBC("JDBC", 24),
    SPRING("Spring", 16),
    TEST_DESIGN("Test Design", 10),
    PAGE_OBJECT("Page Object", 16),
    SELENIUM("Selenium", 16);

    @Getter
    private final int hours;
    @Getter
    private final String courseName;

    Hours(String courseName, int hours) {
        this.hours = hours;
        this.courseName = courseName;
    }
}

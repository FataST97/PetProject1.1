package com.griddynamics.qa.course.module;

import java.time.LocalDateTime;

import static com.griddynamics.qa.course.module.Hours.*;

public class AQAStudent extends Student {

    public AQAStudent(String name, LocalDateTime startDate) {
        super.setName(name);
        super.setCurriculumName("J2EE Developer");
        super.setCourseHoursText("\n" + TEST_DESIGN.getCourseName() + " " + TEST_DESIGN.getHours() + " hours" +
                "\n" + PAGE_OBJECT.getCourseName() + " " + PAGE_OBJECT.getHours() + " hours" +
                        "\n" + SELENIUM.getCourseName() + " " + SELENIUM.getHours() + " hours.");
        super.setDurationOfStudying(TEST_DESIGN.getHours() + PAGE_OBJECT.getHours() + SELENIUM.getHours());
        super.setStartDate(startDate);
        super.setEndDate(timeCalculation.calculateEndDate(startDate, getDurationOfStudying()));
        super.setHowMuchTimeIsLeft(timeCalculation.
                calculateHowMuchTimeIsLeft(LocalDateTime.of(2020, 6, 8, 15, 0), getEndDate()));
    }
}

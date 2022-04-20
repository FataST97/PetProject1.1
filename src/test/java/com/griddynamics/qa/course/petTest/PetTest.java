package com.griddynamics.qa.course.petTest;

import com.griddynamics.qa.course.io.InputAndOutput;
import com.griddynamics.qa.course.model.AQAStudent;
import com.griddynamics.qa.course.model.JavaStudent;
import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.service.TimeCalculation;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class PetTest {
    LocalDateTime testDate = LocalDateTime.of(2020,6,8,15,0);
    Student studentJava = new JavaStudent("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0));
    Student studentAQA = new AQAStudent("Sidorov Ivan", LocalDateTime.of(2020, 5, 30, 10, 0));

    @Test
    public void testEndDate() {
        LocalDateTime expectedDateJava = LocalDateTime.of(2020, 6, 9, 18, 0);
        LocalDateTime expectedDateAQA = LocalDateTime.of(2020, 6, 8, 12, 0);
        Assert.assertEquals(expectedDateJava, studentJava.getEndDate());
        Assert.assertEquals(expectedDateAQA, studentAQA.getEndDate());
    }

    @Test
    public void testHoursLeft() {
        Duration expectedJava = Duration.ofHours(27);
        Duration expectedAQA = Duration.ofHours(-3);
        Assert.assertEquals(expectedJava, studentJava.getHoursLeft());
        Assert.assertEquals(expectedAQA, studentAQA.getHoursLeft());
    }

    @Test
    public void testPrintResult() {
        Assert.assertTrue(InputAndOutput.resultString(1,studentJava).startsWith("Long report: "));
        Assert.assertTrue(InputAndOutput.resultString(0,studentAQA).contains("Short report: "));
    }

    @Test
    public void testIsFinished(){
        Assert.assertFalse(new TimeCalculation().isFinished(testDate,studentJava.getEndDate()));
        Assert.assertTrue(new TimeCalculation().isFinished(testDate,studentAQA.getEndDate()));
    }
}


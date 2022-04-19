package com.griddynamics.qa.course.petTest;

import com.griddynamics.qa.course.IAO.Input;
import com.griddynamics.qa.course.IAO.Output;
import com.griddynamics.qa.course.module.AQAStudent;
import com.griddynamics.qa.course.module.JavaStudent;
import com.griddynamics.qa.course.module.Student;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class PetTest {
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
    public void testHowMuchTimeIsLeft() {
        int[] expectedJava = new int[]{1, 3};
        int[] expectedAQA = new int[]{0, 3};
        Assert.assertArrayEquals(expectedJava, studentJava.getHowMuchTimeIsLeft());
        Assert.assertArrayEquals(expectedAQA, studentAQA.getHowMuchTimeIsLeft());
    }

    @Test
    public void testPrintResult() {
        String studentNameJava = "Ivanov Ivan";
        int parameterOne = 1;
        String studentNameAQA = "Sidorov Ivan";
        int parameterZero = 0;
        Assert.assertTrue(Input.resultString(studentNameJava,parameterOne,studentJava,studentAQA).startsWith("Long report: "));
        Assert.assertTrue(Input.resultString(studentNameAQA, parameterZero,studentJava,studentAQA).contains("Short report: "));
    }

    @Test
    public void testWrongStudentName() {
        String studentName = "Wrong Name";
        int parameter = 1;
        Assert.assertTrue(Input.resultString(studentName, parameter,studentJava,studentAQA).contains("Error"));
    }
}


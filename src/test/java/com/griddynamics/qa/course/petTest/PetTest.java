package com.griddynamics.qa.course.petTest;

import com.griddynamics.qa.course.model.J2EEStudent;
import com.griddynamics.qa.course.model.JavaStudent;
import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.service.TimeCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class PetTest {
    LocalDateTime testDate = LocalDateTime.of(2020,6,8,15,0);
    TimeCalculator calc = new TimeCalculator();

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new JavaStudent("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)), LocalDateTime.of(2020, 6, 9, 18, 0),Duration.ofHours(27)},
                {new JavaStudent("Kotsur Volodymyr", LocalDateTime.of(2015, 9, 1, 8, 0)), LocalDateTime.of(2015, 9, 9, 16, 0),Duration.ofHours(-41615)},
                {new J2EEStudent("Sidorov Ivan", LocalDateTime.of(2020, 5, 30, 10, 0)), LocalDateTime.of(2020, 6, 8, 12, 0),Duration.ofHours(-3)},
                {new J2EEStudent("Stabrovsky Sergiy", LocalDateTime.of(2020, 4, 20, 8, 0)), LocalDateTime.of(2020, 4, 27, 10, 0),Duration.ofHours(-1013)}
        });
    }
    private final Student student;
    private final LocalDateTime expectedDate;
    private final Duration timeLeft;

    public PetTest(Student student,LocalDateTime expectedDate,Duration timeLeft){
        this.student = student;
        this.expectedDate= expectedDate;
        this.timeLeft = timeLeft;
    }

    @Test
    public void testEndDate() {
        Assert.assertEquals(expectedDate,calc.calculateEndDate(student));
    }

    @Test
    public void testTimeLeft() {
        Assert.assertEquals(timeLeft, calc.calculateHoursLeft(student));
    }

    @Test
    public void testIsFinished() {
        if (testDate.isAfter(calc.calculateEndDate(student))) {
            Assert.assertTrue(new TimeCalculator().isFinished(student));
        } else Assert.assertFalse(new TimeCalculator().isFinished(student));

    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongStartDate(){
        Student futureStudent = new JavaStudent
                ("Fantastic Creature", LocalDateTime.of(5000,12,29,16,0));
        calc.calculateEndDate(futureStudent);
    }
}


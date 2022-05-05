package com.griddynamics.qa.course;

import com.griddynamics.qa.course.io.Io;
import com.griddynamics.qa.course.model.J2EEStudent;
import com.griddynamics.qa.course.model.JavaStudent;
import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.service.StudentReporter;
import com.griddynamics.qa.course.service.TimeCalculator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    static Io IO = new Io(new StudentReporter(new TimeCalculator()));

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new J2EEStudent("Sidorov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)),
                new JavaStudent("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)));

        int parameter = IO.readParameter();
        for (Student student : students) {
            IO.printResult(parameter, student);
        }
    }
}

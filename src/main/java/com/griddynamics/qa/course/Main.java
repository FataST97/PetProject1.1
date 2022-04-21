package com.griddynamics.qa.course;

import com.griddynamics.qa.course.io.InputAndOutput;
import com.griddynamics.qa.course.model.AQAStudent;
import com.griddynamics.qa.course.model.JavaStudent;
import com.griddynamics.qa.course.model.Student;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new AQAStudent("Sidorov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)),
                new JavaStudent("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0)));

        int parameter = InputAndOutput.readParameter();
        for (Student student : students) {
            InputAndOutput.showResultString(parameter, student);
        }
    }
}

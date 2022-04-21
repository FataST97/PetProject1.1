package com.griddynamics.qa.course.io;

import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.service.StudentReporter;

import java.util.Scanner;

public class Io {

    private Io() {
        throw new IllegalStateException("Utility class");
    }

    public static int readParameter() {
        int parameter;
        System.out.println("Choose an output option 1 - full info, 0 - short info");
        try {
            parameter = Integer.parseInt(new Scanner(System.in).nextLine());
            if (parameter != 0) {
                parameter = 1;
            }
        } catch (NumberFormatException e) {
            parameter = 1;
        }
        return parameter;
    }

    public static void printResult(int parameter, Student student) {
        StudentReporter report = new StudentReporter();
        switch (parameter) {
            case 0 -> System.out.println(report.createShortOutput(student) + "\n");
            case 1 -> System.out.println(report.createLongReport(student) + "\n");
            default -> System.out.println("Error, Missed parameter");
        }
    }
}

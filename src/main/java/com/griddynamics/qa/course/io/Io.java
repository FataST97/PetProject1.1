package com.griddynamics.qa.course.io;

import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.service.StudentReporter;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class Io {

    private final StudentReporter studentReporter;

    public int readParameter() {
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

    public void printResult(int parameter, Student student) {
        switch (parameter) {
            case 0 -> System.out.println(studentReporter.createShortOutput(student) + "\n");
            case 1 -> System.out.println(studentReporter.createLongReport(student) + "\n");
            default -> System.out.println("Error, Missed parameter");
        }
    }
}

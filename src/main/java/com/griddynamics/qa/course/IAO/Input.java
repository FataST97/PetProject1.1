package com.griddynamics.qa.course.IAO;

import com.griddynamics.qa.course.module.Student;

import java.util.Scanner;

public class Input {
    public static String readName(Scanner scan) {
        System.out.println("Enter student's name using the following example - 'surname name'");
        return scan.nextLine();
    }

    public static int readParameter(Scanner scan) {
        int parameter;
        System.out.println("Choose an output option 1 - full info, 0 - short info");
        try {
            parameter = Integer.parseInt(scan.nextLine());
            if (parameter != 0) {
                parameter = 1;
            }
        } catch (NumberFormatException e) {
            parameter = 1;
        }
        return parameter;
    }

    public static String resultString(String name, int parameter, Student student1, Student student2) {
        String result = "";
        Output output = new Output();
        if (name.equalsIgnoreCase(student1.getName())) {
            switch (parameter) {
                case 0:
                    return result = output.createShortOutput(student1);
                case 1:
                    return result = output.createLongReport(student1);
            }
        } else if (name.equalsIgnoreCase(student2.getName())) {
            switch (parameter) {
                case 0:
                    return result = output.createShortOutput(student2);
                case 1:
                    return result = output.createLongReport(student2);
            }
        } else return "Error, Wrong user name";
        return result;
    }
}

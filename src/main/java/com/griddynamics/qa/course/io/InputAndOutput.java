package com.griddynamics.qa.course.io;

import com.griddynamics.qa.course.model.Student;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputAndOutput {
    protected String createShortOutput(Student student) {
        return "Short report: "+ student.getName() + " (" + student.getCurriculumName() + ")-" +
                createIsFinishedText(student.getHoursLeft(),
                        student.getTimeCalculation().isFinished(student.getPresentDate(),
                                student.getEndDate()));
    }

    protected String createIsFinishedText(Duration timeLeft, boolean isFinished) {
        if (isFinished && timeLeft.toDays() == 0)
            return "Training completed. " + Math.abs(timeLeft.toHours()) + " hours have passed since the end";
        else if (isFinished)
            return "Training completed. " + Math.abs(timeLeft.toDays()) + " d " + Math.abs(timeLeft.toHours()-24) + " hours have passed since the end";
        else if (timeLeft.toDays() == 0)
            return "Training is not finished. " + Math.abs(timeLeft.toHours()) + " hours are left until the end";
        else
            return "Training is not finished. " + Math.abs(timeLeft.toDays()) + " d " + Math.abs(timeLeft.toHours()-24) + " hours are left until the end";
    }

    protected String createLongReport(Student student) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mm a");
        return "Long report: "+
                "\nStudent name - " + student.getName() +
                "\nWorking time - " + "8-hour school day from 10 to 18" +
                "\nProgram name - " + student.getCurriculumName() +
                "\nProgram duration " + student.getDurationOfStudying().toHours() + " hours" +
                "\nCourses: " + student.getCourseHoursText() +
                "\nStart date " + dtf.format(student.getStartDate()) +
                "\nEnd date " + dtf.format(student.getEndDate()) +
                "\n" + createIsFinishedText(student.getHoursLeft(),
                student.getTimeCalculation().isFinished(LocalDateTime.of(2020, 6, 8, 15, 0),
                        student.getEndDate()));
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

    public static String resultString(int parameter, Student student) {
        InputAndOutput inputAndOutput = new InputAndOutput();
        return switch (parameter) {
            case 0 -> inputAndOutput.createShortOutput(student);
            case 1 -> inputAndOutput.createLongReport(student);
            default -> "Error, Missed parameter";
        };
    }
}

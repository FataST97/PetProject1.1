package com.griddynamics.qa.course.service;

import com.griddynamics.qa.course.model.Student;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StudentReporter {

    private final TimeCalculator calculator;

    private String createCourseInfo(Student student) {
        return student.getCourse().stream()
                .map(course -> "\n" + course.getCourseName() + " " + course.getDuration().toHours() + " hours")
                .collect(Collectors.joining());
    }

    private String createFinishedText(Duration timeLeft, boolean isFinished) {
        if (isFinished && timeLeft.toDays() == 0)
            return "Training completed. " + Math.abs(timeLeft.toHours()) + " hours have passed since the end";
        else if (isFinished)
            return "Training completed. " + Math.abs(timeLeft.toDays()) + " d " + Math.abs(timeLeft.toHours() - 24) + " hours have passed since the end";
        else if (timeLeft.toDays() == 0)
            return "Training is not finished. " + Math.abs(timeLeft.toHours()) + " hours are left until the end";
        else
            return "Training is not finished. " + Math.abs(timeLeft.toDays()) + " d " + Math.abs(timeLeft.toHours() - 24) + " hours are left until the end";
    }

    public String createShortOutput(Student student) {
        return "Short report: " + student.getName() + " (" + student.getCurriculumName() + ")-" +
                createFinishedText(calculator.calculateHoursLeft(student), calculator.isFinished(student));
    }

    public String createLongReport(Student student) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mm a");
        return "Long report: " +
                "\nStudent name - " + student.getName() +
                "\nWorking time - " + "8-hour school day from 10 to 18" +
                "\nProgram name - " + student.getCurriculumName() +
                "\nProgram duration " + calculator.calculateDuration(student).toHours() + " hours" +
                "\nCourses: " + createCourseInfo(student) +
                "\nStart date " + dtf.format(student.getStartDate()) +
                "\nEnd date " + dtf.format(calculator.calculateEndDate(student)) +
                "\n" + createFinishedText(calculator.calculateHoursLeft(student), calculator.isFinished(student));
    }
}


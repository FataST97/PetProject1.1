package com.griddynamics.qa.course.IAO;

import com.griddynamics.qa.course.module.Student;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Output {
    protected String createShortOutput(Student student) {
        return "Short report: "+ student.getName() + " (" + student.getCurriculumName() + ")-" +
                createIsFinishedText(student.getHowMuchTimeIsLeft(),
                        student.getTimeCalculation().isFinished(LocalDateTime.of(2020, 6, 8, 15, 0),
                                student.getEndDate()));
    }

    protected String createIsFinishedText(int[] howMuchTimeIsLeft, boolean isFinished) {
        if (isFinished && howMuchTimeIsLeft[0] == 0)
            return "Training completed. " + howMuchTimeIsLeft[1] + " hours have passed since the end";
        else if (isFinished)
            return "Training completed. " + howMuchTimeIsLeft[0] + " d " + howMuchTimeIsLeft[1] + " hours have passed since the end";
        else if (howMuchTimeIsLeft[0] == 0)
            return "Training is not finished. " + howMuchTimeIsLeft[1] + " hours are left until the end";
        else
            return "Training is not finished. " + howMuchTimeIsLeft[0] + " d " + howMuchTimeIsLeft[1] + " hours are left until the end";
    }

    protected String createLongReport(Student student) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy h:mm a");
        return "Long report: "+
                "\ncom.griddynamics.qa.course.students.Student name - " + student.getName() +
                "\nWorking time - " + "8-hour school day from 10 to 18" +
                "\nProgram name - " + student.getCurriculumName() +
                "\nProgram duration " + student.getDurationOfStudying() + " hours" +
                "\nCourses: " + student.getCourseHoursText() +
                "\nStart date " + dtf.format(student.getStartDate()) +
                "\nEnd date " + dtf.format(student.getEndDate()) +
                "\n" + createIsFinishedText(student.getHowMuchTimeIsLeft(),
                student.getTimeCalculation().isFinished(LocalDateTime.of(2020, 6, 8, 15, 0),
                        student.getEndDate()));
    }
}

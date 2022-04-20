package com.griddynamics.qa.course;

import com.griddynamics.qa.course.io.InputAndOutput;
import com.griddynamics.qa.course.model.AQAStudent;
import com.griddynamics.qa.course.model.JavaStudent;
import com.griddynamics.qa.course.model.Student;
import com.griddynamics.qa.course.model.StudentInfo;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> STUDENTS = Arrays.asList(
                new AQAStudent(StudentInfo.Sidorov_Ivan.getStudentName(), StudentInfo.Sidorov_Ivan.getStartDate()),
                new JavaStudent(StudentInfo.Ivanov_Ivan.getStudentName(), StudentInfo.Ivanov_Ivan.getStartDate()));
        int parameter = InputAndOutput.readParameter();
        for (Student student: STUDENTS){
            System.out.println(InputAndOutput.resultString(parameter,student)+"\n");
        }
    }
}

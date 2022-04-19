import com.griddynamics.qa.course.IAO.Input;
import com.griddynamics.qa.course.module.AQAStudent;
import com.griddynamics.qa.course.module.JavaStudent;
import com.griddynamics.qa.course.module.Student;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student IvanovJava = new JavaStudent("Ivanov Ivan", LocalDateTime.of(2020, 6, 1, 10, 0));
        Student SidorovAQA = new AQAStudent("Sidorov Ivan",LocalDateTime.of(2020, 6, 1, 10, 0));
        System.out.println(Input.resultString(Input.readName(scan),Input.readParameter(scan),IvanovJava,SidorovAQA));


    }
}

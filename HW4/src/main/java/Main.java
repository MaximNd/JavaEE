import annotations.LoggingAspect;

import annotations.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.Student2;

/**
 * Created by Макс on 24.02.2018.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("./config.xml");
        Student vasya1 = (Student)context.getBean("vasya");
        vasya1.startExam();
        vasya1.endExam();

        System.out.println("");
        System.out.println("==========");
        System.out.println("");

        Student2 petya = (Student2)context.getBean("petya");
        petya.startExam();
        petya.endExam();

    }
}

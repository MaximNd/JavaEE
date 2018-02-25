import data.Student.Student;
import data.entities.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import worker.WorkWithStudents;
import worker.WorkWithTeacher;

import java.util.Date;

/**
 * Created by Макс on 25.02.2018.
 */
public class App{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        WorkWithStudents worker =
                (WorkWithStudents) context.getBean("worker");
//new WorkWithStudents();
        Student testStudent = new Student(1,"Vlad Valt", 5);
        worker.saveStudentToDb(testStudent);
        Student st = worker.getStudentById(1);
        System.out.println(st);

        WorkWithTeacher workWithTeacher =
                (WorkWithTeacher) context.getBean("teachersWorker");
        Teacher teacher = new Teacher(new Date(), "+1234567890", "Max", "Nedashkivsky", 1);
        teacher = workWithTeacher.addTeacher(teacher);
        workWithTeacher.saveTacher(teacher);

    }
}

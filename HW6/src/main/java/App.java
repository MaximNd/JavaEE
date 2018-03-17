import data.entities.*;
import data.entities.embeddables.Address;
import data.entities.embeddables.FullName;
import data.entities.enums.TestType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import worker.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
public class App{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        GradebookWorker gradebookWorker = (GradebookWorker) context.getBean("GradebookWorker");
        LecturesWorker lecturesWorker = (LecturesWorker) context.getBean("LecturesWorker");
        StudentsDataWorker studentsDataWorker = (StudentsDataWorker) context.getBean("StudentsDataWorker");
        StudentsWorker studentsWorker = (StudentsWorker) context.getBean("StudentsWorker");
        TeacherWorker teacherWorker = (TeacherWorker) context.getBean("TeacherWorker");
        TestWorker testWorker = (TestWorker) context.getBean("TestWorker");

        // Create fullname for teacher
        FullName tch1FullName = new FullName();
        tch1FullName.setFirstname("TCH1FirstName");
        tch1FullName.setLastname("TCH1LastName");
        tch1FullName.setMidname("TCH1MidName");

        // Create teacher
        Teacher teacher1 = new Teacher();
        teacher1.setBirthDate(new Date(10));
        teacher1.setFullName(tch1FullName);
        System.out.println(teacherWorker.addTeacher(teacher1));

        // Create Lecture1
        Lecture lecture1 = new Lecture();
        lecture1.setName("Introduction to Spring");
        lecture1.setCredits(45);
        lecture1.setTeacher(teacher1);
        System.out.println(lecturesWorker.addLecture(lecture1));

        // Create Lecture2
        Lecture lecture2 = new Lecture();
        lecture2.setName("Spring advanced");
        lecture2.setCredits(75);
        lecture2.setTeacher(teacher1);
        System.out.println(lecturesWorker.addLecture(lecture2));

        // Create Test1(SR) for lecture1
        Test test1 = new Test();
        test1.setTestName("Test1");
        test1.setTestType(TestType.SR);
        test1.setText("Lorem ipsum dolor sit amet");
        System.out.println(testWorker.addTest(test1));

        // Create Test2(KR) for lecture1
        Test test2 = new Test();
        test2.setTestName("Test2");
        test2.setTestType(TestType.KR);
        test2.setText("Lorem ipsum dolor sit amet");
        System.out.println(testWorker.addTest(test2));

        // Create Test3(KR) for lecture1
        Test test3 = new Test();
        test3.setTestName("Test3");
        test3.setTestType(TestType.KR);
        test3.setText("Lorem ipsum dolor sit amet");
        System.out.println(testWorker.addTest(test3));

        // Create Address for Student
        Address st1Address = new Address();
        st1Address.setCountry("C1");
        st1Address.setSity("S1");
        st1Address.setStreet("Street1");

        // Create Student data
        StudentData st1Data = new StudentData();
        st1Data.setBirthday(new Date(12));
        st1Data.setAddress(st1Address);
        System.out.println(studentsDataWorker.addStudentsData(st1Data));

        // Create fullname for student
        FullName st1FullName = new FullName();
        st1FullName.setFirstname("ST1FirstName");
        st1FullName.setLastname("ST1LastName");
        st1FullName.setMidname("ST1MidName");

        // Create student
        Student student1 = new Student();
        student1.setCourse("1");
        student1.setFullName(st1FullName);
        student1.setStudentData(st1Data);
        List<Lecture> st1Lectures = new ArrayList<Lecture>();
        st1Lectures.add(lecture1);
        st1Lectures.add(lecture2);
        student1.setLectures(st1Lectures);
        System.out.println(studentsWorker.addStudent(student1));

        // Set Mark for test1
        Gradebook gr1 = new Gradebook();
        gr1.setMark(70);
        gr1.setStudent(student1);
        gr1.setTest(test1);
        System.out.println(gradebookWorker.addGradebook(gr1));

        // Set Mark for test2
        Gradebook gr2 = new Gradebook();
        gr2.setMark(60);
        gr2.setStudent(student1);
        gr2.setTest(test2);
        System.out.println(gradebookWorker.addGradebook(gr2));

        // Set Mark for test3
        Gradebook gr3 = new Gradebook();
        gr3.setMark(100);
        gr3.setStudent(student1);
        gr3.setTest(test3);
        System.out.println(gradebookWorker.addGradebook(gr3));

        System.out.println(studentsWorker.findStudent(2).getLectures());
    }
}


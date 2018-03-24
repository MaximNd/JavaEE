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

        // Create Address for Student
        Address st2Address = new Address();
        st2Address.setCountry("C2");
        st2Address.setSity("S2");
        st2Address.setStreet("Street2");

        // Create Student data
        StudentData st2Data = new StudentData();
        st2Data.setBirthday(new Date(12));
        st2Data.setAddress(st2Address);
        System.out.println(studentsDataWorker.addStudentsData(st2Data));

        // Create fullname for student
        FullName st2FullName = new FullName();
        st2FullName.setFirstname("ST2FirstName");
        st2FullName.setLastname("ST2LastName");
        st2FullName.setMidname("ST2MidName");

        // Create student
        Student student2 = new Student();
        student2.setCourse("2");
        student2.setFullName(st2FullName);
        student2.setStudentData(st2Data);
        System.out.println(studentsWorker.addStudent(student2));

        // Create Address for Student
        Address st3Address = new Address();
        st3Address.setCountry("C3");
        st3Address.setSity("S3");
        st3Address.setStreet("Street3");

        // Create Student data
        StudentData st3Data = new StudentData();
        st3Data.setBirthday(new Date(12));
        st3Data.setAddress(st3Address);
        System.out.println(studentsDataWorker.addStudentsData(st3Data));

        // Create fullname for student
        FullName st3FullName = new FullName();
        st3FullName.setFirstname("ST3FirstName");
        st3FullName.setLastname("ST3LastName");
        st3FullName.setMidname("ST3MidName");

        // Create student
        Student student3 = new Student();
        student3.setCourse("2");
        student3.setFullName(st3FullName);
        student3.setStudentData(st3Data);
        List<Lecture> st3Lectures = new ArrayList<Lecture>();
        st3Lectures.add(lecturesWorker.findLecture(2));
        System.out.println(studentsWorker.addStudent(student3));

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

        // Queries(JPQL,Named Queries)
        System.out.println("STUDENTS");
        System.out.println("ALL STUDENTS: ");
        System.out.println(studentsWorker.getAllStudents());
        System.out.println();

        System.out.println("GET ALL STUDENTS WITH LECTURE COUNT 0: ");
        System.out.println(studentsWorker.getStudentsByLecturesCount(0));
        System.out.println("GET ALL STUDENTS WITH LECTURE COUNT 2: ");
        System.out.println(studentsWorker.getStudentsByLecturesCount(2));
        System.out.println();

        System.out.println("GET ALL STUDENTS BY COURSE 1: ");
        System.out.println(studentsWorker.getAllStudentsByCourse("1"));
        System.out.println("GET ALL STUDENTS BY COURSE 2: ");
        System.out.println(studentsWorker.getAllStudentsByCourse("2"));
        System.out.println();

        System.out.println("GET ALL STUDENTS SKIP 1 AND TAKE 2: ");
        System.out.println(studentsWorker.getStudendsWithLimit(1, 2));
        System.out.println("GET ALL STUDENTS SKIP 0 AND TAKE 1: ");
        System.out.println(studentsWorker.getStudendsWithLimit(0, 1));
        System.out.println("GET ALL STUDENTS SKIP 2 AND TAKE 1: ");
        System.out.println(studentsWorker.getStudendsWithLimit(2, 1));
        System.out.println();

        System.out.println("TEACHERS");
        System.out.println("GET ALL TEACHERS: ");
        System.out.println(teacherWorker.getAllTeachers());

        System.out.println("LECTURES");
        System.out.println("GET ALL LECTURES: ");
        System.out.println(lecturesWorker.getAllLectures());
        System.out.println("GET ALL LECTURES WITH CREDITS 45: ");
        System.out.println(lecturesWorker.getAllLecturesByCredits(45));
        System.out.println("GET ALL LECTURES ORDER BY CREDITS ASC: ");
        System.out.println(lecturesWorker.getAllLecturesSortedByCreditsAsc());
        System.out.println("GET ALL LECTURES ORDER BY CREDITS DESC: ");
        System.out.println(lecturesWorker.getAllLecturesSortedByCreditsDesc());

        System.out.println("TEST");
        System.out.println("GET ALL TESTS: ");
        System.out.println(testWorker.getAllTests());
        System.out.println("GET COUNT OF KR: ");
        System.out.println(testWorker.getCountByTestType(TestType.KR));
        System.out.println("GET COUNT OF SR: ");
        System.out.println(testWorker.getCountByTestType(TestType.SR));
    }
}


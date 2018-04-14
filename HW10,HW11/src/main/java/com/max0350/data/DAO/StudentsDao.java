package com.max0350.data.DAO;

import com.max0350.data.entities.Student;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface StudentsDao {
    Student addStudent(Student student);

    Student getStudent(int id);
    List<Student> getAllStudents();
    List<Student> getStudentsWithLimit(int skip, int take);
    List<Student> getAllStudentsByLecturesCount(int lecturesCount);

    Student saveStudent(Student student);

    Student deleteStudent(Student student);
}

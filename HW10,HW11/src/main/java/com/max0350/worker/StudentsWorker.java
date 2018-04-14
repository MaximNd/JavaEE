package com.max0350.worker;

import com.max0350.data.DAO.StudentsDao;
import com.max0350.data.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public class StudentsWorker {
    @Autowired
    StudentsDao studentsDoa;

    public Student addStudent(Student student) {
        student = studentsDoa.addStudent(student);
        return student;
    }

    public Student findStudent(int id) {
        return studentsDoa.getStudent(id);
    }


    public List<Student> getAllStudents() {
        return this.studentsDoa.getAllStudents();
    }

    public Student updateStudent(Student student) {
        return this.studentsDoa.saveStudent(student);
    }

    @Transactional
    public Student deleteStudentById(int id) {
        Student student = this.studentsDoa.getStudent(id);
        this.studentsDoa.deleteStudent(student);
        return student;
    }
}

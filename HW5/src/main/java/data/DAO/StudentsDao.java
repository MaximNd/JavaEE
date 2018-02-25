package data.DAO;

import data.Student.Student;

/**
 * Created by Макс on 25.02.2018.
 */
public interface StudentsDao {
    void addStudent(Student student);
    Student getStudentById(int id);
}

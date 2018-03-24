package data.DAO;

import data.entities.Student;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface StudentsDao {
    Student addStudent(Student student);

    Student getStudent(int id);
    List<Student> getAllStudents();
    List<Student> getAllStudentsByCourse(String course);
    List<Student> getStudentsWithLimit(int skip, int take);
    List<Student> getAllStudentsByLecturesCount(int lecturesCount);

    void saveStudent(Student student);
}

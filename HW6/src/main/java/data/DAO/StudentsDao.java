package data.DAO;

import data.entities.Student;

/**
 * Created by Макс on 04.03.2018.
 */
public interface StudentsDao {
    Student addStudent(Student student);

    Student getStudent(int id);

    void saveStudent(Student student);
}

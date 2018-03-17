package data.DAO;

import data.entities.Teacher;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TeachersDao {
    Teacher addTeacher(Teacher teacher);

    Teacher getTeacher(int id);
    List<Teacher> getAllTeachers();

    void saveTeacher(Teacher teacher);
}

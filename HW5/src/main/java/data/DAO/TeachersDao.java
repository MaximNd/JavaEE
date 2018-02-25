package data.DAO;

import data.entities.Teacher;

/**
 * Created by Макс on 25.02.2018.
 */
public interface TeachersDao {
    void addTeacher(Teacher teacher);
    Teacher getTeacherById(int id);
    void saveTacher(Teacher teacher);
}

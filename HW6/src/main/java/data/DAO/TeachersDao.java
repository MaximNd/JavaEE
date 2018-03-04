package data.DAO;

import data.entities.Teacher;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TeachersDao {
    Teacher addTeacher(Teacher teacher);

    Teacher getTeacher(int id);

    void saveTeacher(Teacher teacher);
}

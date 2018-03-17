package worker;

import data.DAO.TeachersDao;
import data.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public class TeacherWorker {
    @Autowired
    TeachersDao teachersDao;

    public Teacher addTeacher(Teacher teacher) {
        teacher = teachersDao.addTeacher(teacher);
        return teacher;
    }

    public Teacher findTeacher(int id) {
        return teachersDao.getTeacher(id);
    }
    public List<Teacher> getAllTeachers() { return teachersDao.getAllTeachers(); }
}

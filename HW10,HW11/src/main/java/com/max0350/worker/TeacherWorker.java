package com.max0350.worker;

import com.max0350.data.DAO.TeachersDao;
import com.max0350.data.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Teacher> findAllTeacher() {
        return teachersDao.getAllTeachers();
    }

    public Teacher updateTeacher(Teacher teacher) { teachersDao.updateTeacher(teacher); return teacher; }

    public Teacher deleteTeacher(Teacher teacher) { teachersDao.deleteTeacher(teacher); return teacher; }
    @Transactional
    public Teacher deleteTeacherById(int id) {
        Teacher teacher = this.teachersDao.getTeacher(id);
        this.teachersDao.deleteTeacher(teacher);
        return teacher;
    }
}

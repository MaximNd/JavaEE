package com.max0350.data.DAO;

import com.max0350.data.entities.Teacher;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TeachersDao {
    Teacher addTeacher(Teacher teacher);

    Teacher getTeacher(int id);
    List getAllTeachers();

    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
}

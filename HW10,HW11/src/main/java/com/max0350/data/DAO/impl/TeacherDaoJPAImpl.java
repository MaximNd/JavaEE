package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.TeachersDao;
import com.max0350.data.entities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Transactional
public class TeacherDaoJPAImpl implements TeachersDao {
    @PersistenceContext
    private EntityManager em;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }

    public Teacher getTeacher(int id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return em.createQuery("SELECT t FROM Teacher t").getResultList();
    }

    public void updateTeacher(Teacher teacher) {
        em.merge(teacher);
    }

    public void deleteTeacher(Teacher teacher) { em.remove(teacher); }
}

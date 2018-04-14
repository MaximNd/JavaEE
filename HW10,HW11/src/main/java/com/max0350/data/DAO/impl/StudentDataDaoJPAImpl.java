package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.StudentsDataDoa;
import com.max0350.data.entities.StudentData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Transactional
public class StudentDataDaoJPAImpl implements StudentsDataDoa {
    @PersistenceContext
    private EntityManager em;

    public StudentData addStudentData(StudentData studentData) {
        em.persist(studentData);
        return studentData;
    }

    public StudentData getStudentData(int id) {
        return em.find(StudentData.class, id);
    }

    public void saveStudentData(StudentData studentData) {
        em.merge(studentData);
    }
}

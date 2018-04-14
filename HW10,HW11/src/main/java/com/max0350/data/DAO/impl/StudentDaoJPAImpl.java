package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.StudentsDao;
import com.max0350.data.entities.Student;
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
public class StudentDaoJPAImpl implements StudentsDao {
    @PersistenceContext
    private EntityManager em;

    public Student addStudent(Student student) {
        em.persist(student);
        return student;
    }

    public Student getStudent(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return em.createNamedQuery(Student.GET_ALL_STUDENTS).getResultList();
    }

    public List<Student> getStudentsWithLimit(int skip, int take) {
        return em.createQuery("SELECT s FROM Student s", Student.class).setFirstResult(skip).setMaxResults(take).getResultList();
    }

    public List<Student> getAllStudentsByLecturesCount(int lecturesCount) {
        Query query = em.createNamedQuery(Student.GET_STUDENTS_BY_COUNT_LECTURES);
        query.setParameter("countLectures", lecturesCount);
        return query.getResultList();
    }

    public Student saveStudent(Student student) {
        em.merge(student);
        return student;
    }

    public Student deleteStudent(Student student) {
        em.remove(student);
        return student;
    }
}

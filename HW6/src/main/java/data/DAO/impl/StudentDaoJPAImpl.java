package data.DAO.impl;

import data.DAO.StudentsDao;
import data.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public void saveStudent(Student student) {
        em.merge(student);
    }
}

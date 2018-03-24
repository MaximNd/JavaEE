package data.DAO.impl;

import data.DAO.StudentsDao;
import data.entities.Student;
import org.springframework.cache.annotation.Cacheable;
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
@Cacheable("studentsCache")
public class StudentDaoJPAImpl implements StudentsDao {
    @PersistenceContext
    private EntityManager em;

    public Student addStudent(Student student) {
        em.persist(student);
        return student;
    }
    @Transactional
    public Student getStudent(int id) {
        return em.find(Student.class, id);
    }
    @Transactional
    public List<Student> getAllStudents() {
        return em.createNamedQuery(Student.GET_ALL_STUDENTS).getResultList();
    }
    @Transactional
    public List<Student> getAllStudentsByCourse(String course) {
        return em.createNamedQuery(Student.GET_ALL_STUDENTS_BY_COURSE).setParameter("course", course).getResultList();
    }
    @Transactional
    public List<Student> getStudentsWithLimit(int skip, int take) {
        return em.createQuery("SELECT s FROM Student s", Student.class).setFirstResult(skip).setMaxResults(take).getResultList();
    }
    @Transactional
    public List<Student> getAllStudentsByLecturesCount(int lecturesCount) {
        return em.createNamedQuery(Student.GET_STUDENTS_BY_COUNT_LECTURES).setParameter("countLectures", lecturesCount).getResultList();
    }
    @Transactional
    public void saveStudent(Student student) {
        em.merge(student);
    }
}

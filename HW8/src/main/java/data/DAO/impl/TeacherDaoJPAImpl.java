package data.DAO.impl;

import data.DAO.TeachersDao;
import data.entities.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Cacheable("teachersCache")
public class TeacherDaoJPAImpl implements TeachersDao {
    @PersistenceContext
    private EntityManager em;

    public Teacher addTeacher(Teacher teacher) {
        em.persist(teacher);
        return teacher;
    }
    @Transactional()
    public Teacher getTeacher(int id) {
        return em.find(Teacher.class, id);
    }
    @Transactional()
    public List<Teacher> getAllTeachers() {
        return em.createNamedQuery(Teacher.GET_ALL_TEACHERS).getResultList();
    }
    @Transactional()
    public void saveTeacher(Teacher teacher) {
        em.merge(teacher);
    }
}

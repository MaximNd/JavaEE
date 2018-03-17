package data.DAO.impl;

import data.DAO.LecturesDao;
import data.entities.Lecture;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
@Repository
@Transactional
@Cacheable("lecturesCache")
public class LectureDaoJPAImpl implements LecturesDao {
    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        return lecture;
    }

    public Lecture getLecture(int id) {
        return em.find(Lecture.class,id);
    }

    public List<Lecture> getAllLectures() {
        return em.createNamedQuery(Lecture.GET_ALL_LECTURES).getResultList();
    }

    public List<Lecture> getAllLecturesByCredits(double credits) {
        return em.createNamedQuery(Lecture.GET_ALL_LECTURES_BY_CREDITS).setParameter("credits", credits).getResultList();
    }

    public List<Lecture> getAllLecturesSortedByCreditsAsc() {
        return em.createNamedQuery(Lecture.GET_ALL_LECTURES_SORTED_BY_CREDITS_ASC).getResultList();
    }

    public List<Lecture> getAllLecturesSortedByCreditsDesc() {
        return em.createNamedQuery(Lecture.GET_ALL_LECTURES_SORTED_BY_CREDITS_DESC).getResultList();
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }
}

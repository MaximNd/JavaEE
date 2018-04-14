package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.LecturesDao;
import com.max0350.data.entities.Lecture;
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

    @Override
    public List<Lecture> getAllLectures() {
        return em.createQuery("SELECT l FROM Lecture l").getResultList();
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }

    @Override
    public void deleteLecture(Lecture lecture) {
        em.remove(lecture);
    }
}

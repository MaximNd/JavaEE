package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.GradebooksDao;
import com.max0350.data.entities.Gradebook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Transactional
public class GradebookDaoJPAImpl implements GradebooksDao {
    @PersistenceContext
    private EntityManager em;

    public Gradebook addGradebook(Gradebook gradebook) {
        em.persist(gradebook);
        return gradebook;
    }

    public Gradebook getGradebook(int id) {
        return em.find(Gradebook.class,id);
    }

    public void saveGradebook(Gradebook gradebook) {
        em.merge(gradebook);
    }
}

package data.DAO.impl;

import data.DAO.TestsDao;
import data.entities.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Transactional
public class TestDaoJPAImpl implements TestsDao {
    @PersistenceContext
    private EntityManager em;

    public Test addTest(Test test) {
        em.persist(test);
        return test;
    }

    public Test getTest(int id) {
        return em.find(Test.class, id);
    }

    public void saveTest(Test test) {
        em.merge(test);
    }
}

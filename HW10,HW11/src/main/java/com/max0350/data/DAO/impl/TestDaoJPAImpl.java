package com.max0350.data.DAO.impl;

import com.max0350.data.DAO.TestsDao;
import com.max0350.data.entities.Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public List<Test> geAllTests() {
        return em.createQuery("SELECT t FROM Test t").getResultList();
    }

    public Test saveTest(Test test) {
        em.merge(test);
        return test;
    }

    @Override
    public Test deleteTest(Test test) {
        em.remove(test);
        return test;
    }
}

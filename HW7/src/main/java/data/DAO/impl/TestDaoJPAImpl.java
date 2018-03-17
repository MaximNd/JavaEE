package data.DAO.impl;

import data.DAO.TestsDao;
import data.entities.Test;
import data.entities.enums.TestType;
import org.springframework.cache.annotation.Cacheable;
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
@Cacheable("testsCache")
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

    public List<Test> getAllTests() {
        return em.createNamedQuery(Test.GET_ALL_TESTS).getResultList();
    }

    public long getCountByTestType(TestType type) {
        return (Long) em.createNamedQuery(Test.COUNT_OF_SELECTED_TYPE_TEST).setParameter("testType", type).getSingleResult();
    }

    public void saveTest(Test test) {
        em.merge(test);
    }
}

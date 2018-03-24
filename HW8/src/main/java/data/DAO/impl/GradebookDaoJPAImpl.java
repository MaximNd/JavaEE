package data.DAO.impl;

import data.DAO.GradebooksDao;
import data.entities.Gradebook;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Макс on 04.03.2018.
 */
@Repository
@Cacheable("gradebooksCache")
public class GradebookDaoJPAImpl implements GradebooksDao {
    @PersistenceContext
    private EntityManager em;

    public Gradebook addGradebook(Gradebook gradebook) {
        em.persist(gradebook);
        return gradebook;
    }
    @Transactional
    public Gradebook getGradebook(int id) {
        return em.find(Gradebook.class,id);
    }
    @Transactional
    public void saveGradebook(Gradebook gradebook) {
        em.merge(gradebook);
    }
}

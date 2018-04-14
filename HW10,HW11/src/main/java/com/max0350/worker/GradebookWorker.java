package com.max0350.worker;

import com.max0350.data.DAO.GradebooksDao;
import com.max0350.data.entities.Gradebook;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Макс on 04.03.2018.
 */
public class GradebookWorker {
    @Autowired
    GradebooksDao gradebooksDao;

    public Gradebook addGradebook(Gradebook gradebook) {
        gradebook = gradebooksDao.addGradebook(gradebook);
        return gradebook;
    }

    public Gradebook findGradebook(int id) {
        return gradebooksDao.getGradebook(id);
    }
}

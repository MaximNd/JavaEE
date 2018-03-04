package worker;

import data.DAO.GradebooksDao;
import data.entities.Gradebook;
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

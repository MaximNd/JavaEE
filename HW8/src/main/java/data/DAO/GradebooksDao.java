package data.DAO;

import data.entities.Gradebook;

/**
 * Created by Макс on 04.03.2018.
 */
public interface GradebooksDao {
    Gradebook addGradebook(Gradebook gradebook);

    Gradebook getGradebook(int id);

    void saveGradebook(Gradebook gradebook);
}

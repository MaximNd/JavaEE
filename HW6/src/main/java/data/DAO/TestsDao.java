package data.DAO;

import data.entities.Test;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TestsDao {
    Test addTest(Test test);

    Test getTest(int id);

    void saveTest(Test test);
}

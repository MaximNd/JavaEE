package worker;

import data.DAO.TestsDao;
import data.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Макс on 04.03.2018.
 */
public class TestWorker {
    @Autowired
    TestsDao testsDao;

    public Test addTest(Test test) {
        test = testsDao.addTest(test);
        return test;
    }

    public Test findTest(int id) {
        return testsDao.getTest(id);
    }
}

package data.DAO;

import data.entities.Test;
import data.entities.enums.TestType;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TestsDao {
    Test addTest(Test test);

    Test getTest(int id);
    List<Test> getAllTests();
    long getCountByTestType(TestType type);

    void saveTest(Test test);
}

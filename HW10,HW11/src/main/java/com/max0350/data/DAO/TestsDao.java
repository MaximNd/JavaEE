package com.max0350.data.DAO;

import com.max0350.data.entities.Test;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public interface TestsDao {
    Test addTest(Test test);

    Test getTest(int id);
    List<Test> geAllTests();

    Test saveTest(Test test);

    Test deleteTest(Test test);
}

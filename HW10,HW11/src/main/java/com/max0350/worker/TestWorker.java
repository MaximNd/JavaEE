package com.max0350.worker;

import com.max0350.data.DAO.TestsDao;
import com.max0350.data.entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Test> getAllTests() { return this.testsDao.geAllTests(); }

    public Test updateTest(Test test) {
        testsDao.saveTest(test);
        return test;
    }

    @Transactional
    public Test deleteTestById(int id) {
        Test test = testsDao.getTest(id);
        testsDao.deleteTest(test);
        return test;
    }
}

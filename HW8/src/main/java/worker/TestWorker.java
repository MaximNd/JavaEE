package worker;

import data.DAO.TestsDao;
import data.entities.Test;
import data.entities.enums.TestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public class TestWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    TestsDao testsDao;

    public Test addTest(final Test test) {
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    testsDao.addTest(test);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return test;
    }

    public Test findTest(int id) {
        return testsDao.getTest(id);
    }

    public List<Test> getAllTests() {
        return testsDao.getAllTests();
    }

    public long getCountByTestType(final TestType type) {
        return transactionTemplate.execute(new TransactionCallback<Long>(){
            public Long doInTransaction(TransactionStatus txStatus){
                Long count;
                try {
                    count = testsDao.getCountByTestType(type);
                } catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return count;
            }
        });
    }
}

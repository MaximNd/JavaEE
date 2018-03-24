package worker;

import data.DAO.GradebooksDao;
import data.entities.Gradebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Макс on 04.03.2018.
 */
public class GradebookWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    GradebooksDao gradebooksDao;

    public Gradebook addGradebook(final Gradebook gradebook) {
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    gradebooksDao.addGradebook(gradebook);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return gradebook;
    }

    public Gradebook findGradebook(int id) {
        return gradebooksDao.getGradebook(id);
    }
}

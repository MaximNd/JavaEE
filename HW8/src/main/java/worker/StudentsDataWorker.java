package worker;

import data.DAO.StudentsDataDoa;
import data.entities.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Макс on 04.03.2018.
 */
public class StudentsDataWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    StudentsDataDoa studentsDataDoa;

    public StudentData addStudentsData(final StudentData studentData) {
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    studentsDataDoa.addStudentData(studentData);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });

        return studentData;
    }

    public StudentData findStudentData(int id) {
        return studentsDataDoa.getStudentData(id);
    }
}

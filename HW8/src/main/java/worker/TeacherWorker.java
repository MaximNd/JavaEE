package worker;

import data.DAO.TeachersDao;
import data.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public class TeacherWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    TeachersDao teachersDao;

    public Teacher addTeacher(final Teacher teacher) {
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    teachersDao.addTeacher(teacher);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return teacher;
    }

    public Teacher findTeacher(int id) {
        return teachersDao.getTeacher(id);
    }
    public List<Teacher> getAllTeachers() { return teachersDao.getAllTeachers(); }
}

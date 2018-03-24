package worker;

import data.DAO.StudentsDao;
import data.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
public class StudentsWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    StudentsDao studentsDoa;

    public Student addStudent(final Student student) {
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    studentsDoa.addStudent(student);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return student;
    }

    public Student findStudent(int id) {
        return studentsDoa.getStudent(id);
    }
    public List<Student> getAllStudents() { return studentsDoa.getAllStudents(); }
    public List<Student> getAllStudentsByCourse(String course) { return studentsDoa.getAllStudentsByCourse(course); }
    public List<Student> getStudentsByLecturesCount(int lecturesCoutn) { return studentsDoa.getAllStudentsByLecturesCount(lecturesCoutn); }
    public List<Student> getStudendsWithLimit(int skip, int take) { return studentsDoa.getStudentsWithLimit(skip, take); }
}

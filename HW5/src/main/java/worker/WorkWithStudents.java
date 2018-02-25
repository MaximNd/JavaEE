package worker;

import data.DAO.StudentsDao;
import data.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Макс on 25.02.2018.
 */
public class WorkWithStudents {
    @Autowired
    private StudentsDao studentsDao;

    public StudentsDao getStudentsDao() {
        return studentsDao;
    }

    public void setStudentsDao(StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    public void saveStudentToDb(Student student){
        if ((student!=null)&&(student.getPib()!=null)&&(!"".equals(student.getPib()))&&(student.getCourse()>0)){
            studentsDao.addStudent(student);
            System.out.println("Student have been saved "+student);
        }
    }

    public Student getStudentById(int id) {
        return studentsDao.getStudentById(id);
    }
}

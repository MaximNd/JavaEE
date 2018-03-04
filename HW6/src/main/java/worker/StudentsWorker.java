package worker;

import data.DAO.StudentsDao;
import data.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Макс on 04.03.2018.
 */
public class StudentsWorker {
    @Autowired
    StudentsDao studentsDoa;

    public Student addStudent(Student student) {
        student = studentsDoa.addStudent(student);
        return student;
    }

    public Student findStudent(int id) {
        return studentsDoa.getStudent(id);
    }
}

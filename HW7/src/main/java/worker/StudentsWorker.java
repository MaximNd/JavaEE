package worker;

import data.DAO.StudentsDao;
import data.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List<Student> getAllStudents() { return studentsDoa.getAllStudents(); }
    public List<Student> getAllStudentsByCourse(String course) { return studentsDoa.getAllStudentsByCourse(course); }
    public List<Student> getStudentsByLecturesCount(int lecturesCoutn) { return studentsDoa.getAllStudentsByLecturesCount(lecturesCoutn); }
    public List<Student> getStudendsWithLimit(int skip, int take) { return studentsDoa.getStudentsWithLimit(skip, take); }
}

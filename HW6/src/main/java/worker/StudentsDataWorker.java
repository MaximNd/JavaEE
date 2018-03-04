package worker;

import data.DAO.StudentsDataDoa;
import data.entities.StudentData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Макс on 04.03.2018.
 */
public class StudentsDataWorker {
    @Autowired
    StudentsDataDoa studentsDataDoa;

    public StudentData addStudentsData(StudentData studentData) {
        studentData = studentsDataDoa.addStudentData(studentData);
        return studentData;
    }

    public StudentData findStudentData(int id) {
        return studentsDataDoa.getStudentData(id);
    }
}

package data.DAO;

import data.entities.StudentData;

/**
 * Created by Макс on 04.03.2018.
 */
public interface StudentsDataDoa {
    StudentData addStudentData(StudentData studentData);

    StudentData getStudentData(int id);

    void saveStudentData(StudentData studentData);
}

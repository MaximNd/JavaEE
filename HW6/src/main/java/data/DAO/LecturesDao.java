package data.DAO;

import data.entities.Lecture;

/**
 * Created by Макс on 26.02.2018.
 */
public interface LecturesDao {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);

    void saveLecture(Lecture lecture);
}


package data.DAO;

import data.entities.Lecture;

import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
public interface LecturesDao {

    Lecture addLecture(Lecture lecture);

    Lecture getLecture(int id);
    List<Lecture> getAllLectures();
    List<Lecture> getAllLecturesByCredits(double credits);
    List<Lecture> getAllLecturesSortedByCreditsAsc();
    List<Lecture> getAllLecturesSortedByCreditsDesc();

    void saveLecture(Lecture lecture);
}


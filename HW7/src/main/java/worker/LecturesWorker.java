package worker;

import data.DAO.LecturesDao;
import data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
public class LecturesWorker {
    @Autowired
    LecturesDao lecturesDao;

    public Lecture addLecture(Lecture lecture){
        lecture = lecturesDao.addLecture(lecture);
        return lecture;
    }

    public Lecture findLecture(int id) {
        return lecturesDao.getLecture(id);
    }
    public List<Lecture> getAllLectures() {
        return lecturesDao.getAllLectures();
    }

    public List<Lecture> getAllLecturesByCredits(double credits) {
        return lecturesDao.getAllLecturesByCredits(credits);
    }

    public List<Lecture> getAllLecturesSortedByCreditsAsc() {
        return lecturesDao.getAllLecturesSortedByCreditsAsc();
    }

    public List<Lecture> getAllLecturesSortedByCreditsDesc() {
        return lecturesDao.getAllLecturesSortedByCreditsDesc();
    }
}

